package com.example.taller_4

import android.app.usage.UsageStatsManager
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.taller_4.ui.theme.Taller4Theme
import java.util.concurrent.TimeUnit

class UsageTimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller4Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    UsageTimeScreen()
                }
            }
        }
    }
}

@Composable
fun UsageTimeScreen() {
    val context = LocalContext.current
    val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
    val endTime = System.currentTimeMillis()
    val startTime = endTime - TimeUnit.DAYS.toMillis(1)
    val usageStats = usageStatsManager.queryAndAggregateUsageStats(startTime, endTime)
    val totalUsageTime = usageStats.values.sumOf { it.totalTimeInForeground }

    Text(text = "Total usage time: ${TimeUnit.MILLISECONDS.toMinutes(totalUsageTime)} minutes")
}

@Preview(showBackground = true)
@Composable
fun UsageTimeScreenPreview() {
    Taller4Theme {
        UsageTimeScreen()
    }
}