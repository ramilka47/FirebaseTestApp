package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.ViewModel
import ru.ramil.firebasetestapp.domain.GetTokenUseCase

class MainViewModel(private val getTokenUseCase: GetTokenUseCase) : ViewModel() {
}