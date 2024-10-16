from django import forms

class StockTrackerAppForm(forms.Form):
    entered_stock = forms.CharField(
        label="",
        max_length=50,
        error_messages={
            "required": "Enter Stock Symbol First :)",
            "max_length": "Such a long stock name does not exist :("
        },
        widget=forms.TextInput(attrs={
            'class': 'input-search',
            'placeholder': 'Enter Stock Symbol...'
        })
    )

    entered_company = forms.CharField(
        label="",
        max_length=50,
        error_messages={
            "required": "Enter Company Name First :)",
            "max_length": "Such a long company name does not exist :("
        },
        widget=forms.TextInput(attrs={
            'class': 'input-search',
            'placeholder': 'Enter Company Name...'
        })
    )
