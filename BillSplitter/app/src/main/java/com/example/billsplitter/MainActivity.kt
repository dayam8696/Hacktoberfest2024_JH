package com.example.billsplitter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.billsplitter.ui.theme.BillSplitterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BillSplitterTheme {
                // A surface container using the 'background' color from the theme
                    MainUI("Android")
            }
        }
    }
}

@Composable
fun MainUI(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        CompleteUI()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BillSplitterTheme {
        MainUI("Android")
    }
}