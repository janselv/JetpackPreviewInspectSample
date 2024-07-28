package me.jansv.previewinspect.module

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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun ModuleComposable(text: String? = null) {
    val context = LocalContext.current
    val activityName = context.javaClass.simpleName
    val appName = context.applicationContext.javaClass.simpleName

    MaterialTheme {
        Surface {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = text
                        ?: "ModuleComposable: \nactivity: $activityName \napplication: $appName",
                )
            }
        }
    }
}

/* Running it with ADB
 *
 * adb shell am start \
 *   -n me.jansv.previewinspect.module.test/androidx.compose.ui.tooling.PreviewActivity \
 *   -e composable "me.jansv.previewinspect.module.ModuleComposableKt.ModuleComposablePreview"
 */
@Preview
@Composable
fun ModuleComposablePreview() = ModuleComposable()

/* Running it with ADB
 *
 * adb shell am start \
 *   -n me.jansv.previewinspect.module.test/androidx.compose.ui.tooling.PreviewActivity \
 *   -e composable "me.jansv.previewinspect.module.ModuleComposableKt.ModuleComposablePreview" \
 *   -e parameterProviderClassName "me.jansv.previewinspect.module.TextParameterProvider"
 */
@Preview
@Composable
fun ModuleComposablePreview(
    @PreviewParameter(TextParameterProvider::class) text: String,
) = ModuleComposable(text = text)

class TextParameterProvider : PreviewParameterProvider<String> {
    override val values = (1..5).map { "Param #$it" }.asSequence()
}
