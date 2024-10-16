# models.py
from django.db import models
from django.contrib.auth.models import User

class UserStock(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    stock_symbol = models.CharField(max_length=100)
    company_name = models.CharField(max_length=100)
    lower_limit = models.DecimalField(max_digits=10, decimal_places=2, default=0)
    upper_limit = models.DecimalField(max_digits=10, decimal_places=2, default=0)
    
    def __str__(self):
        return f"{self.company_name} ({self.stock_symbol})"

class UserNumber(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    phone_number = models.CharField(max_length=15, blank=True)

    def __str__(self):
        return f"{self.user.username}'s Number"