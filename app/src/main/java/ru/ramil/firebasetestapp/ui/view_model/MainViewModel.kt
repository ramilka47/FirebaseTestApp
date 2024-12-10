package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.ramil.firebasetestapp.domain.GetTokenUseCase
import ru.ramil.firebasetestapp.domain.RegisterTokenUseCase

class MainViewModel(
    private val registerTokenUseCase: RegisterTokenUseCase,
    private val getTokenUseCase: GetTokenUseCase) : ViewModel() {

    private val tokenMutable = MutableLiveData<String>()
    val tokenLiveData : LiveData<String>
        get() = tokenMutable

    fun onCreate(){
        register()
    }

    private fun register(){
        viewModelScope.launch {
            registerTokenUseCase.execute()
            getToken()
        }
    }

    private fun getToken(){
        viewModelScope.launch {
            tokenMutable.postValue(getTokenUseCase.execute())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}