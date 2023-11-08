package com.app.funfacts.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.funfacts.UserViewModel

@Composable
fun NavigationGraph(userViewModel: UserViewModel = viewModel()) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRouter.USER_SCREEN
    ) {
        composable(AppRouter.USER_SCREEN) {
            UserScreen(
                userViewModel,
                welcomeScreen = {
                    println("Show Welcome Screen")
                    println(it.first)
                    println(it.second)
                    navController.navigate(AppRouter.WELCOME_SCREEN + "/${it.first}/${it.second}")
                }
            )
        }
        composable("${AppRouter.WELCOME_SCREEN}/{${AppRouter.USER_NAME}}/{${AppRouter.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(name = AppRouter.USER_NAME) {
                    type = NavType.StringType
                },
                navArgument(name = AppRouter.ANIMAL_SELECTED) {
                    type = NavType.StringType
                }
            )
        ) {
            val username = it?.arguments?.getString(AppRouter.USER_NAME)
            val animalSelected = it?.arguments?.getString(AppRouter.ANIMAL_SELECTED)
            WelcomeScreen(username,animalSelected)
        }
    }
}