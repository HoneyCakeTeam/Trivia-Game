package com.example.triviagame.ui.screens.categories.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@Composable
fun Header(
    modifier: Modifier = Modifier,
    score: Int,
    onClickProfile: () -> Unit = { },
    onClickScore: () -> Unit = { }
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = stringResource(R.string.user_image),
            modifier = Modifier
                .size(40.dp)
                .clickable { onClickProfile() }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier
                .padding(vertical = 6.dp, horizontal = 8.dp)
                .clickable { onClickScore() }
        ) {
            Text(
                text = score.toString(),
                color = White_FF,
                modifier = modifier,
                style = Typography.titleLarge
            )
            Image(
                painter = painterResource(id = R.drawable.ic_score),
                contentDescription = stringResource(R.string.score_icon),
                modifier = Modifier.size(24.dp),
            )
        }
    }
}