package com.example.triviagame.ui.screens.categories

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "categories"

fun NavGraphBuilder.categoriesRoute(navController: NavController) {
    composable(route = ROUTE) {
        //CategoriesScreen(navController)
        CategoriesScreen(navController)
    }
}


