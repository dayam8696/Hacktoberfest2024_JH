package com.example.billsplitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CompleteUI() {

    var inputAmount by rememberSaveable {
        mutableStateOf("")
    }

    var personCount by rememberSaveable {
        mutableStateOf(1)
    }

    var tipPercentage by rememberSaveable {
        mutableStateOf(0f)
    }

    Column(Modifier.fillMaxWidth()) {
        AmountDisplay(
            amount = formatTwoDecimalPoints(
                getTotalPerPersonAmount(
                    inputAmount = inputAmount,
                    tipPercentage = tipPercentage,
                    personCount = personCount
                )
            )
        )
        UserInputUI(
            inputAmount = inputAmount,
            inputAmountChange = { inputAmount = it },
            peronCount = personCount,
            onAddOrReducePerson = {
                if (it < 0) {
                    if (personCount != 1) {
                        personCount--
                    }
                } else {
                    personCount++
                }
            },
            tipPercentage = tipPercentage,
            tipPercentageChange = { tipPercentage = it }
        )
    }
}

@Composable
fun AmountDisplay(amount: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color.Cyan
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 22.dp)
        ) {
            Text(
                text = "Total Per Person",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "₹ ${amount}",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserInputUI(
    inputAmount: String,
    inputAmountChange: (String) -> Unit,
    peronCount: Int,
    onAddOrReducePerson: (Int) -> Unit,
    tipPercentage: Float,
    tipPercentageChange: (Float) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 12.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = inputAmount,
                onValueChange = { inputAmountChange.invoke(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = { Text(text = "Enter Your Amount") },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }
                )
            )

            if (inputAmount.isNotBlank()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Split",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.fillMaxWidth(0.6f))

                    CustomButton(imageVector = Icons.Default.KeyboardArrowUp) {
                        onAddOrReducePerson.invoke(1)
                    }

                    Text(
                        text = "$peronCount",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )

                    CustomButton(imageVector = Icons.Default.KeyboardArrowDown) {
                        onAddOrReducePerson.invoke(-1)
                    }

                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Tip",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )

                    Spacer(modifier = Modifier.fillMaxWidth(0.8f))

                    Text(
                        text = "₹ ${formatTwoDecimalPoints(
                            getTipAmount(
                                inputAmount = inputAmount,
                                tipPercentage = tipPercentage
                            )
                        )}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    )
                }

                Text(
                    text = "${formatTwoDecimalPoints(tipPercentage.toString())} %",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                )

                Slider(
                    value = tipPercentage,
                    onValueChange = {
                        tipPercentageChange.invoke(it)
                    },
                    valueRange = 0f..100f,
                    steps = 99,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

            }
        }
    }
}


@Composable
fun CustomButton(imageVector: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp)
            .clickable {
                onClick.invoke()
            }, shape = CircleShape
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainPreview() {
    Column {
        AmountDisplay(amount = "$100.00")
        UserInputUI(
            inputAmount = "$1000.00",
            inputAmountChange = {},
            peronCount = 3,
            onAddOrReducePerson = {},
            tipPercentage = 16.67f,
            tipPercentageChange = {}
        )
    }
}