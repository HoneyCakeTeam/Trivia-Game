package com.example.triviagame.ui

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.triviagame.TriviaNavGraph
import com.example.triviagame.ui.theme.TriviaGameTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TriviaApp() {
    TriviaGameTheme {
        Scaffold() {
            val navController = rememberNavController()
            TriviaNavGraph(navController)
        }

    }

}