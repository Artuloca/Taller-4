package com.example.taller_4

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taller_4.ui.theme.Taller4Theme
import java.util.Calendar

class MainActivity : ComponentActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var backgroundColor by mutableStateOf(Color.White)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        setContent {
            Taller4Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "greeting") {
                    composable("greeting") { GreetingScreen(navController, backgroundColor) }
                    composable("next") {  }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val x = it.values[0]
            val y = it.values[1]
            val z = it.values[2]

            // Cambiar el color de fondo según la dirección del movimiento
            backgroundColor = when {
                x > 5 -> Color.Red
                x < -5 -> Color.Blue
                y > 5 -> Color.Green
                y < -5 -> Color.Yellow
                z > 5 -> Color.Cyan
                z < -5 -> Color.Magenta
                else -> Color.White
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No se necesita implementar
    }
}

@Composable
fun GreetingScreen(navController: NavController, backgroundColor: Color) {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greetingText = when (currentHour) {
        in 0..11 -> "Good Morning"
        in 12..17 -> "Good Afternoon"
        else -> "Good Evening"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$greetingText!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = { navController.navigate("next") }) {
            Text(text = "Siguiente")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    Taller4Theme {
        GreetingScreen(rememberNavController(), Color.White)
    }
}