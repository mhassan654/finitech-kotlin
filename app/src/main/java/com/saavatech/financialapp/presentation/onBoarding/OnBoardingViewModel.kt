package com.saavatech.financialapp.presentation.onBoarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saavatech.financialapp.domain.useCases.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCase: AppEntryUseCase): ViewModel() {
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                // Handle navigation to login screen
                saveAppEntry()
            }

            OnBoardingEvent.NavigateToLogin -> TODO()
            OnBoardingEvent.NavigateToRegister -> TODO()
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntryUseCase
        }
    }

    sealed class OnBoardingEvent{
        data object NavigateToLogin: OnBoardingEvent()
        data object NavigateToRegister: OnBoardingEvent()
        data object SaveAppEntry: OnBoardingEvent()
    }
}