from django.shortcuts import render, redirect
from django.views import View
from .forms import StockTrackerAppForm

import requests
import datetime as dt
from datetime import timedelta
from twilio.rest import Client
import os
from dotenv import load_dotenv

from .models import UserStock, UserNumber
from django.contrib.auth.models import User

# Create your views here.
load_dotenv()

STOCK_API = "VMOB9RDZL75NAJSL"

#news api detail
NEWS_API = "648ed12df9444c98a8f7276b13dc3555"

#twilio api details

account_sid = os.getenv('account_sid') #Add Your twilio account_sid
auth_token = os.getenv('auth_token') #Add Your twilio auth_sid
phone = os.getenv('phone') #Add Your twilio phone number

class st_homepage(View):

    def get(self, request):
       form = StockTrackerAppForm()
       print(request.user)
       return render(request, "stock_tracker_app/home.html", {
           "form": form
       })

    def post(self, request):
        form = StockTrackerAppForm(request.POST)

        #model update add stock data
        if form.is_valid():

            entered_stock = form.cleaned_data['entered_stock']
            print("Entered Stock:", entered_stock)
            entered_company = form.cleaned_data['entered_company']
            print("Entered company:", entered_company)            

            #model update
            UserStock.objects.create(
                user=request.user,
                stock_symbol=entered_stock,
                company_name=entered_company
            )
            
            return redirect('st_homepage')
        else:
            return render(request, "stock_tracker_app/home.html", {
           "form": form
       })


class st_allstocks(View):
    def get(self, request):
       current_user = request.user
       user_stocks = UserStock.objects.filter(user=current_user)
       return render(request, "stock_tracker_app/MyStocks.html", {"stocks": user_stocks})

    def post(self, request):
        print("OK")
        ul = request.POST.getlist('upper_limit')
        ll = request.POST.getlist('lower_limit')

        current_user = request.user
        user_stock = UserStock.objects.filter(user=current_user)

        #model update stock data
        for i in range(len(user_stock)):
            stock = user_stock[i]
            stock.lower_limit = ll[i]
            stock.upper_limit = ul[i]
            stock.save()
        print("limits updated succ")
        return redirect("st_allstocks")


class st_stocknews(View):
    def get(self, request):
       name = request.user
       data_collected = False

       return render(request, "stock_tracker_app/news.html", {
           "name":name,
           "data_collected": data_collected
           })
    

    def post(self, request):
        name = request.user
        # phone_number = UserNumber.objects.get(user=name).phone_number
        phone_number = name.usernumber.phone_number
        print("Number:", phone_number)

        #empty news_data list that will be paased into 'news' template
        news_data = []

        now = dt.datetime.now()
        # previous_date = (now - timedelta(1)).date()
        previous_date = "2024-09-18"
        # pp_date = (now - timedelta(2)).date()
        pp_date = "2024-09-17"

        user_stocks = UserStock.objects.filter(user=name)
        for stock in user_stocks:
            its_holiday = False

            sym = stock.stock_symbol
            comp = stock.company_name

            #getting stock data
            response = requests.get(f"https://www.alphavantage.co/query?"
                                    f"function=TIME_SERIES_DAILY"
                                    f"&symbol={sym}&"
                                    f"outputsize=compact"
                                    f"&apikey={STOCK_API}")
            response.raise_for_status()
            data = response.json()
            print("Data:", data)
            try:
                previous_day_closing = float(data["Time Series (Daily)"][str(previous_date)]["3. low"])
                previous_p_day_closing = float(data["Time Series (Daily)"][str(pp_date)]["3. low"])
                print("previous_p_day_closing",previous_p_day_closing)

            except KeyError:
                its_holiday = True
                print("its holiday")
                news_data.append({
                    "its_holiday": its_holiday,
                    "company_name": comp
                })
            else:
                diff_percent = round((float(previous_day_closing - previous_p_day_closing) / previous_day_closing) * 100, 3)
                # if diff_percent < stock.lower_limit or diff_percent > stock.upper_limit:
                if diff_percent < 0 or diff_percent > 0:
                    # getting news
                    response2 = requests.get(f"https://newsapi.org/v2/everything?"
                                            f"q={comp}"
                                            f"&from={pp_date}&to={previous_date}"
                                            "&sortBy=popularity"
                                            f"&apiKey={NEWS_API}")
                    response2.raise_for_status()

                    data2 = response2.json()
                    print("Data2:", data2)

                    news_data.append({"its_holiday": its_holiday,
                                      "company_name": comp,
                                      "source": data2["articles"][0]["source"]["name"],
                                       "news1":{
                                           "title":data2["articles"][1]["title"],
                                           "content":data2["articles"][1]["content"],
                                           "url":data2["articles"][1]["url"]
                                       },
                                        "news2":{
                                            "title":data2["articles"][2]["title"],
                                           "content":data2["articles"][2]["content"],
                                           "url":data2["articles"][2]["url"]
                                        },
                                    })
                    
                    # twilio message send
                    if its_holiday:
                        print("Its holiday")
                        pass
                    else:
                        text = f'''
                            Company: {comp}
                            Difference:{diff_percent}%
                            Headline1: {data2["articles"][1]["title"]}
                            Headline2: {data2["articles"][2]["title"]}
                        '''

                    client = Client(account_sid, auth_token)
                    message = client.messages.create(
                        body=text,
                        from_=phone,
                        to=f'+91{phone_number}'
                    )
                    print(message.sid, message.status, message.error_code, message.error_message)

        return render(request, "stock_tracker_app/news.html",{
            "data_collected": True,
            "name": name,
            "news_data": news_data,
        })

    



                                                                                                                                                                                                                                                                                                      
