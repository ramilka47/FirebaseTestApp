package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.ViewModel
import ru.ramil.firebasetestapp.domain.SetTokenUseCase

class FirebaseViewModel(private val setTokenUseCase: SetTokenUseCase) : ViewModel() {
}