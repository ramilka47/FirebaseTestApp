package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.ramil.firebasetestapp.domain.SetTokenUseCase

class FirebaseViewModel(private val setTokenUseCase: SetTokenUseCase) : ViewModel() {

    fun setToken(token : String){
        viewModelScope.launch {
            setTokenUseCase.execute(token)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}