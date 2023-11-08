package com.app.funfacts.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.funfacts.QuoteComposable
import com.app.funfacts.R
import com.app.funfacts.TextComponent
import com.app.funfacts.TopBar
import com.app.funfacts.ui.theme.QuotesViewModel

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            TopBar(value = "Welcome $username \uD83D\uDE0D")

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = stringResource(id = R.string.thank_you),
                textSize = 23.sp
            )

            Spacer(modifier = Modifier.size(80.dp))

            val finalText =
                if (animalSelected == "Cat") "You are a Cat Lover."
                else "You are a Dog Lover."

            TextComponent(
                textValue = finalText,
                textSize = 24.sp
            )
            val quotesViewModel: QuotesViewModel = viewModel()

            QuoteComposable(
                value = quotesViewModel.generateRandomQuotes(animalSelected!!)
            )
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    WelcomeScreen("username", "animalSelected")
}