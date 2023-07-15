package com.example.triviagame.ui.screens.play

import androidx.lifecycle.SavedStateHandle
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class PlayViewModel @Inject constructor(
    private val repository: TriviaRepository,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PlayUiState>(PlayUiState()) {

    val args = PlayArgs(savedStateHandle)

    init {

    }

}