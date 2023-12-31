package com.honey.triviagame.ui.screens.answer_details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.honey.triviagame.R
import com.honey.triviagame.ui.screens.answer_details.AnswerUiState
import com.honey.triviagame.ui.theme.Success
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.theme.White_FF
import com.honey.triviagame.ui.theme.Wrong
import com.honey.triviagame.ui.util.QuestionState


@Composable
fun QuestionItem(question: AnswerUiState, index: Int) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        QuestionCircleLabel(questionNumber = index)
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = question.questionText,
                style = Typography.bodyMedium,
                color = White_FF,
                modifier = Modifier.wrapContentWidth(),
                textAlign = TextAlign.Start,
                maxLines = 2
            )
            Text(
                text = question.userAnswer,
                style = Typography.bodySmall,
                color = if (question.state == QuestionState.CORRECT) Success else Wrong,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

        }
        Image(
            painter = if (question.state == QuestionState.CORRECT) painterResource(id = R.drawable.resource_true) else painterResource(
                id = R.drawable.resource_false
            ),
            contentDescription = if (question.state == QuestionState.CORRECT) " Question Success" else " Question Wrong"
        )

    }
}