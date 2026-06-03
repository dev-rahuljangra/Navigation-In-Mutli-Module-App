package com.devrj.feature_home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.devrj.core_navigation.AppNavController
import com.devrj.core_navigation.AppRoute

fun NavGraphBuilder.homeGraph(appNavController: AppNavController){
    navigation<AppRoute.Home.Graph>(
        startDestination = AppRoute.Home.Screen
    ){
        composable<AppRoute.Home.Screen>{
            HomeScreen(appNavController)
        }
    }
}