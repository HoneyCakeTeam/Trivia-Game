package com.example.triviagame.ui.screens.categories

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.triviagame.ui.LocalNavigationProvider


private const val ROUTE = "categories"

fun NavGraphBuilder.categoriesRoute() {

    composable(route = ROUTE) {
        CategoriesScreen()
    }
}


