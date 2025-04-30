package com.saavatech.financialapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saavatech.financialapp.presentation.onBoarding.OnBoardingScreen
import com.saavatech.financialapp.presentation.welcome.WelcomeScreen

@Composable
fun MainNavigation(navController: NavHostController){
    val destinationsNavigator = RoutesNavigator();

    NavHost(navController = navController, startDestination = NavRoutes.WelcomeScreen.route){
        composable(route = NavRoutes.WelcomeScreen.route){
            WelcomeScreen()
        }
        composable(route = NavRoutes.OnBoardingScreen.route){
            OnBoardingScreen(
                event ={}
            )
        }

    }

}

class RoutesNavigator(private val navHostController: NavHostController? = null){
    fun navigateTo(route: String){
        navHostController?.navigate(route)
    }

    fun navigateBack(){
        navHostController?.popBackStack()
    }

}