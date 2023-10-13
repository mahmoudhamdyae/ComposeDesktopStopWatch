import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchDisplay(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isRunning by remember { mutableStateOf(false) }
    var isPaused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Start Button
            Button(
                enabled = !isRunning,
                onClick = {
                    isRunning = true
                    isPaused = false
                    onStartClick()
                }
            ) {
                Text("Start")
            }
            Spacer(Modifier.width(16.dp))

            // Pause Button
            Button(
                enabled = !isPaused && isRunning,
                onClick = {
                    isRunning = false
                    isPaused = true
                    onPauseClick()
                }
            ) {
                Text("Pause")
            }
            Spacer(Modifier.width(16.dp))

            // Reset Button
            Button(
                enabled = isRunning || isPaused,
                onClick = {
                    isRunning = false
                    isPaused = false
                    onResetClick()
                }
            ) {
                Text("Reset")
            }
        }
    }
}