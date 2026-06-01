package com.devrj.feature_auth.navgraph

import AppRoute
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devrj.feature_auth.routes.AuthRoutes
import com.devrj.feature_auth.ui.LoginScreen
import com.devrj.feature_auth.ui.SignUpScreen

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation<AppRoute.AuthGraph>(
        startDestination = AuthRoutes.ScreenA
    ){
        composable<AuthRoutes.ScreenA>{
            LoginScreen(navController)
        }

        composable<AuthRoutes.ScreenB>{
            SignUpScreen(navController)
        }
    }
}