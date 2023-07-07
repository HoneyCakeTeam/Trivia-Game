package com.example.triviagame.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.composable.CategoryCard
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical12
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel
import com.example.triviagame.ui.viewmodel.state.CategoriesUiState


@Preview
@Composable
fun CategoriesScreen(viewModel: TriviaGameViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    CategoriesContent(state = state)
}

@Composable
fun CategoriesContent(
    state: CategoriesUiState,
) {
    Column(
        Modifier
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header()
        ChooseText()
        SpacerVertical12()
        LazyGrid(state = state)

    }
}

@Composable
private fun LazyGrid(
    state: CategoriesUiState,
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy((-16).dp),


        ) {
        items(state.CategoreyList.size) {

            CategoryCard(
                CategoryImage = state.CategoreyList[it].image,
                text = state.CategoreyList[it].name
            )
        }
    }
}

@Composable
private fun ChooseText() {
    Text(
        text = "Choose your game type",
        fontSize = 18.sp,
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.montserrat_semibold))
    )
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "user",
            modifier = Modifier.size(40.dp)
        )
        Box {
            Text(
                text = "32100",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(
                    Font(R.font.montserrat_semibold)
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "arrow left",
                modifier = Modifier.padding(start = 48.dp)
            )
        }

    }
}


