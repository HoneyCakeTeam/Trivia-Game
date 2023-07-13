package com.example.triviagame.ui.screens.play.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.composable.Timer
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_EC

@Composable
fun QuestionCard(state: PlayUiState) {
    Box{
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(CardBackgroundColor)
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Timer(
                    state = state,
                    activeBarColor = Secondary,
                    modifier = Modifier.size(64.dp)
                )
                state.questions.getOrNull(state.currentQuestionIndex)?.question?.let {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = it,
                        color = White_EC,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
        QuestionNumberCard(state = state, modifier = Modifier.align(Alignment.TopCenter))
    }
}
