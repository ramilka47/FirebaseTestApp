package ru.ramil.firebasetestapp.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ramil.firebasetestapp.domain.GetTokenUseCase
import ru.ramil.firebasetestapp.domain.SetTokenUseCase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val getTokenUseCase : GetTokenUseCase,
    private val setTokenUseCase: SetTokenUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){
            FirebaseViewModel::class.java -> {
                FirebaseViewModel(setTokenUseCase) as T
            }
            MainViewModel::class.java -> {
                MainViewModel(getTokenUseCase) as T
            }
            else -> throw Exception("class with name $modelClass not supported")
        }
    }
}