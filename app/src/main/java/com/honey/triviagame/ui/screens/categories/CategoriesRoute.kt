package com.honey.triviagame.ui.screens.categories

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "categories"

fun NavGraphBuilder.categoriesRoute() {

    composable(route = ROUTE) {
        CategoriesScreen()
    }
}


