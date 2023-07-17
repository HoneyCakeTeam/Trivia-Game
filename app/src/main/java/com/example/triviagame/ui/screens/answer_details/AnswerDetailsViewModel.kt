package com.example.triviagame.ui.screens.answer_details

import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class AnswerDetailsViewModel @Inject constructor(private val repository: TriviaRepository) :
    BaseViewModel<AnswerUiState>(AnswerUiState()),AnswerDetailsInteractionsListener{

}