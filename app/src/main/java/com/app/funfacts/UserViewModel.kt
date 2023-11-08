package com.app.funfacts

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.funfacts.ui.theme.data.UserScreenState
import com.app.funfacts.ui.theme.events.UserDataUiEvents

class UserViewModel : ViewModel() {

    companion object {
        const val TAG = "UserViewModel"
    }

    var uiState = mutableStateOf(UserScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "UserNameEntered")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG, "AnimalSelected")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}

