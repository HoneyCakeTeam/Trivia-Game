package com.honey.triviagame.ui.screens.play.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.honey.triviagame.R
import com.honey.triviagame.ui.screens.play.PlayUiState
import com.honey.triviagame.ui.theme.Black_87
import com.honey.triviagame.ui.theme.Secondary

@Composable
fun QuestionNumberCard(state: PlayUiState, modifier: Modifier) {
    Card(
        modifier = modifier
            .width(186.dp)
            .padding(bottom = 26.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Secondary)
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.question),
                color = Black_87,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "${state.currentQuestionIndex + 1}/${state.numberOfQuestions}",
                color = Black_87,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

