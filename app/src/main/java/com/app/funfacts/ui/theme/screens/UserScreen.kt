package com.app.funfacts.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.funfacts.Animal
import com.app.funfacts.ButtonComponent
import com.app.funfacts.R
import com.app.funfacts.TextComponent
import com.app.funfacts.TextFieldComponent
import com.app.funfacts.TopBar
import com.app.funfacts.UserViewModel
import com.app.funfacts.ui.theme.events.UserDataUiEvents

@Composable
fun UserScreen(
    userViewModel: UserViewModel,
    welcomeScreen: (valuesPair: Pair<String, String>) -> Unit
    ) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            TopBar(stringResource(id = R.string.hi_there))

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = stringResource(id = R.string.lets_learn),
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = stringResource(id = R.string.information),
                textSize = 20.sp
            )

            Spacer(modifier = Modifier.size(80.dp))

            TextComponent(
                textValue = stringResource(id = R.string.name),
                textSize = 20.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(
                onTextChange = {
                    userViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = stringResource(id = R.string.do_you_like),
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Animal(
                    image = R.drawable.dog,
                    animalSelected = {
                        userViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userViewModel.uiState.value.animalSelected == "Dog"
                )

                Spacer(modifier = Modifier.weight(1f))

                Animal(
                    image = R.drawable.cat,
                    animalSelected = {
                        userViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userViewModel.uiState.value.animalSelected == "Cat"
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userViewModel.isValidState()){
                ButtonComponent(
                    detailScreen = {
                        println("Coming Here")
                        println("${userViewModel.uiState.value.nameEntered} and ${userViewModel.uiState.value.animalSelected}")

                        welcomeScreen(
                            Pair(
                                userViewModel.uiState.value.nameEntered,
                                userViewModel.uiState.value.animalSelected
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserPreview() {
    UserScreen(userViewModel = UserViewModel(), welcomeScreen = {})
}