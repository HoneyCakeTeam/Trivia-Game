package com.example.triviagame.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical12
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.White_FF

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,

) {
    BottomSheetScaffold(
        sheetBackgroundColor = CardBackgroundColor,
        sheetPeekHeight = 0.1.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(211.dp)
                    .background(CardBackgroundColor)
                    .padding(top = 16.dp),
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

                    val selectedChipIndex = remember { mutableStateOf(2) }

                        ChipItem(
                            text = "easy",
                            selected = selectedChipIndex.value == 1,
                            onChipState = { selectedChipIndex.value = 1 }
                        )

                        ChipItem(
                            text = "medium",
                            selected = selectedChipIndex.value == 2,
                            onChipState = { selectedChipIndex.value = 2 }
                        )

                        ChipItem(
                            text = "hard",
                            selected = selectedChipIndex.value == 3,
                            onChipState = { selectedChipIndex.value = 3 }
                        )
                    }

                SpacerVertical12()
                ButtonItem(
                    text = "Play",
                    modifier = Modifier.padding( start = 16.dp, end = 16.dp)
                )

            }

        }) {}

}


