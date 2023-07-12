package com.example.triviagame.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.triviagame.data.repository.TriviaRepository
import javax.inject.Inject

class TriviaGameViewModel @Inject constructor(
    repository: TriviaRepository
):ViewModel(){

}


