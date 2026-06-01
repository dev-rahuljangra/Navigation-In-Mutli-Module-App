package com.devrj.feature_on_boarding.navgraph

import AppRoute
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devrj.core_navigation.NavigationManager
import com.devrj.feature_on_boarding.routes.OnBoardingRoutes
import com.devrj.feature_on_boarding.ui.OnBoardingScreenA
import com.devrj.feature_on_boarding.ui.OnBoardingScreenB

fun NavGraphBuilder.onBoardingGraph(
    navController: NavController,
    navigationManager: NavigationManager
){
    navigation<AppRoute.OnBoardingGraph>(
        startDestination = OnBoardingRoutes.ScreenA
    ){
        composable<OnBoardingRoutes.ScreenA>{
            OnBoardingScreenA(navController)
        }

        composable<OnBoardingRoutes.ScreenB>{
            OnBoardingScreenB(navController,navigationManager)
        }
    }
}