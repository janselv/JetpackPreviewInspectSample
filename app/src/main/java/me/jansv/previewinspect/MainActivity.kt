package me.jansv.previewinspect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppModuleComposable()
        }
    }
}

@Composable
fun AppModuleComposable() {
    val context = LocalContext.current
    val activityName = context.javaClass.simpleName
    val appName = context.applicationContext.javaClass.simpleName

    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "AppModuleComposable: \nactivity: $activityName \napplication: $appName")
            }
        }
    }
}

/* Running it with ADB
 *
 * adb shell am start \
 *   -n me.jansv.previewinspect/androidx.compose.ui.tooling.PreviewActivity \
 *   -e composable "me.jansv.previewinspect.MainActivityKt.AppModuleComposablePreview"
 */
@Preview
@Composable
fun AppModuleComposablePreview() = AppModuleComposable()
