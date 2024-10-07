package com.example.billsplitter

import android.health.connect.datatypes.units.Percentage
import java.text.DecimalFormat

fun getTotalPerPersonAmount(
    inputAmount: String,
    tipPercentage: Float,
    personCount: Int
):String{
    return when {
        inputAmount.isEmpty() -> {
            "0"
        }
        else -> {
            val userAmount = inputAmount.toFloat()
            val tipAmount = userAmount * tipPercentage.div(100)
            val perHeadAmount = (userAmount + tipAmount).div(personCount)
            perHeadAmount.toString()
        }
    }
}

fun formatTwoDecimalPoints(str: String): String {

    return if (str.isEmpty()) {
        ""
    } else {
        val format = DecimalFormat("######################.##")
        format.format(str.toFloat())
    }

}

fun getTipAmount(inputAmount: String, tipPercentage: Float): String {
    return when {
        inputAmount.isEmpty() -> {
            "0"
        }
        else -> {
            val amount = inputAmount.toFloat()
            (amount * tipPercentage.div(100)).toString()
        }
    }
}
