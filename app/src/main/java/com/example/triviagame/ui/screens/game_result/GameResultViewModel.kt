package com.example.triviagame.ui.screens.game_result

import com.example.triviagame.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class GameResultViewModel @Inject constructor() :
    BaseViewModel<GameResultUiState>(GameResultUiState()) {


}