package com.honey.triviagame.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.honey.triviagame.R
import com.honey.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical12
import com.honey.triviagame.ui.theme.CardBackgroundColor
import com.honey.triviagame.ui.theme.Primary
import com.honey.triviagame.ui.theme.White_FF

@Composable
fun LevelSelectorBottomSheet(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    onClickPlay: (String, String) -> Unit,
    selectedCategoryName: String,
    selectedDifficulty: String,
) {

    BottomAppBar(
        containerColor = CardBackgroundColor,
        modifier = modifier
            .fillMaxWidth()
            .height(211.dp)
            .background(CardBackgroundColor)
            .padding(vertical = 16.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Box {
                Card(
                    modifier = Modifier
                        .size(32.dp, 4.dp),
                    backgroundColor = Primary,
                ) {

                }
            }
            Box {
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    text = "Choose your level",
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                    color = White_FF,
                )
            }
            SpacerVertical12()
            Row(

                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                val selectedChipIndex = remember { mutableStateOf(0) }

                ChipItem(
                    text = "easy",
                    selected = selectedChipIndex.value == 1,
                    onClickChip = onClick,
                    onColor = { selectedChipIndex.value = 1 }
                )
                ChipItem(
                    text = "medium",
                    selected = selectedChipIndex.value == 2,
                    onClickChip = onClick, onColor = { selectedChipIndex.value = 2 }

                )
                ChipItem(
                    text = "hard",
                    selected = selectedChipIndex.value == 3,
                    onClickChip = onClick, onColor = { selectedChipIndex.value = 3 }

                )
            }
            ButtonItem(
                text = "Play",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                onClick = { onClickPlay(selectedCategoryName, selectedDifficulty) }
            )
        }
    }
}