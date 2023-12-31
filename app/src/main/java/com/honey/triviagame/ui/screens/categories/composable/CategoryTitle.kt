package com.honey.triviagame.ui.screens.categories.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.honey.triviagame.R
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.theme.White_FF

@Composable
fun CategoryTitle(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.categories_title),
        color = White_FF,
        modifier = modifier,
        style = Typography.titleLarge
    )
}
