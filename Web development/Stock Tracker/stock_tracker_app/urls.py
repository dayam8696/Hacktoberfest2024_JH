from django.contrib import admin
from django.urls import path, include
from . import views

urlpatterns = [
    path('', views.st_homepage.as_view(), name="st_homepage" ),
    path('MyStocks', views.st_allstocks.as_view(), name="st_allstocks" ),
    path('StockNews', views.st_stocknews.as_view(), name="st_stocknews" )
]
