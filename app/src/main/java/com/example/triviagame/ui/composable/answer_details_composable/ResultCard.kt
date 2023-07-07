package com.example.triviagame.ui.composable.answer_details_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF


@Composable
fun ReusableCard(
    modifier: Modifier = Modifier,
    labelText: String,
    questionCount: String,
    icon: Int,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Card)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIcon(icon = icon)
                TextResult(text = labelText, style = Typography.bodyMedium)
            }
            TextResult(text = questionCount, style = Typography.bodyLarge)
        }
    }
}

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    contentDescription: String? = null,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier.size(6.dp),
        painter = painterResource(icon),
        contentDescription = contentDescription,
        tint = tint
    )
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: Color,
    textColor: Color,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(buttonColor),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = Typography.bodyLarge,
            color = textColor
        )
    }
}


@Preview
@Composable
fun Previews() {
    CustomButton(text = "Play again", onClick = {
        //TODO PLAY AGAIN
    }, buttonColor = Card, textColor = White_FF)

}