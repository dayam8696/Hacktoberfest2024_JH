import requests

class CurrencyConverter:
    def __init__(self, url):
        self.data = requests.get(url).json()
        self.currencies = self.data['rates']

    def convert(self, from_currency, to_currency, amount):
        initial_amount = amount
        if from_currency != 'USD':
            amount = amount / self.currencies[from_currency]

        amount = round(amount * self.currencies[to_currency], 2)
        return amount

if __name__ == "__main__":
    url = 'https://api.exchangerate-api.com/v4/latest/USD'
    converter = CurrencyConverter(url)

    from_currency = input("From Currency: ")
    to_currency = input("To Currency: ")
    amount = float(input("Amount: "))
 
    converted_amount = converter.convert(from_currency.upper(), to_currency.upper(), amount)
    print(f"{amount} {from_currency} is equal to {converted_amount} {to_currency}")