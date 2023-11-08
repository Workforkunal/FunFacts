package com.app.funfacts.ui.theme.events

sealed class UserDataUiEvents{

    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue: String) : UserDataUiEvents()
}
