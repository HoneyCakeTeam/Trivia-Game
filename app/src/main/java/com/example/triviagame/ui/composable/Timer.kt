package com.example.triviagame.ui.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_FF
import kotlin.math.min

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    currentTime: Long,
    inactiveBarColor: Color = Color.Green,
    activeBarColor: Color,
    value: Float = 1f,
    strokeWidth: Dp = 6.dp,
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        val barColor = if (currentTime <= 10000) {
            Color.Red
        } else {
            inactiveBarColor
        }
        Canvas(modifier = modifier) {
            val radius = min(size.width, size.height) / 2f
            drawCircle(
                color = activeBarColor,
                radius = radius,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = barColor,
                startAngle = -90f,
                sweepAngle = 360f * value,
                useCenter = false,
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentTime / 1000L).toString(),
            color = White_FF,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TimerPreview() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Timer(
            currentTime = 30000L,
            activeBarColor = Secondary,
            modifier = Modifier.size(64.dp)
        )
    }
}
