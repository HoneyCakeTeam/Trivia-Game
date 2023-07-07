package com.example.triviagame.ui.viewmodel.state

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
data class CategoriesUiState(
 val CategoreyList: List<categoryList> = emptyList())



data class categoryList(
 val name: String = "",
 val image: Int = 0
)