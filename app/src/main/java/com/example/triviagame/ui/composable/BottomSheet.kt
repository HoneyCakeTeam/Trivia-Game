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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical12
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical24
import com.example.triviagame.ui.theme.CardBackgroundColor

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun BottomSheet() {
    BottomSheetScaffold(
        sheetBackgroundColor = CardBackgroundColor,
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
                Box() {
                    Card(
                        modifier = Modifier
                            .size(32.dp, 4.dp),
                        backgroundColor = Color(0xFF734B7C),
                    ) {

                    }
                }
                Box() {
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp),
                        text = "Choose your level",
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        color = Color.White,
                    )
                }
                SpacerVertical12()
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ChipItem(text = "Easy", selected = false, onChipState = {})
                    ChipItem(text = "Medium", selected = false, onChipState = {})
                    ChipItem(text = "Hard", selected = false, onChipState = {})

                }
                SpacerVertical24()

                ButtonItem(
                    text = "Play",
                    modifier = Modifier.width(328.dp).padding(bottom = 16.dp),
                    onClick = {}
                )

            }
        }) {}

}



