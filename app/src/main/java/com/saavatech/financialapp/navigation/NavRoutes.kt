package com.saavatech.financialapp.navigation

sealed class NavRoutes(val route:String){
    object SplashScreen:NavRoutes("splash_screen")
    object OnBoardingScreen:NavRoutes("on_boarding_screen")
    object WelcomeScreen:NavRoutes("welcome_screen")
    object HomeScreen:NavRoutes("home_screen")
}
