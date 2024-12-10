package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.ramil.firebasetestapp.domain.RegisterTokenUseCase
import ru.ramil.firebasetestapp.domain.SetTokenUseCase

class FirebaseViewModel(
    private val registerTokenUseCase: RegisterTokenUseCase,
    private val setTokenUseCase: SetTokenUseCase) : ViewModel() {

    fun onCreate(){
        register()
    }

    private fun register(){
        viewModelScope.launch {
            registerTokenUseCase.execute()
        }
    }

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