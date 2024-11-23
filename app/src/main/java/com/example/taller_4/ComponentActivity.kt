package com.example.taller_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taller_4.ui.theme.Taller4Theme
import java.util.Calendar

class ComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller4Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greetingText = when (currentHour) {
        in 0..11 -> "Good Morning"
        in 12..17 -> "Good Afternoon"
        else -> "Good Evening"
    }
    Text(
        text = "$greetingText!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Taller4Theme {
        Greeting()
    }
}