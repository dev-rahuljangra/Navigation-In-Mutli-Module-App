package com.devrj.navigationinmultimoduleapp

import AppRoute
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devrj.core_navigation.NavigationEvent
import com.devrj.core_navigation.NavigationManager
import com.devrj.design_system.theme.NavigationInMultiModuleAppTheme
import com.devrj.feature_auth.navgraph.authGraph
import com.devrj.feature_on_boarding.navgraph.onBoardingGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavigationInMultiModuleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        navigationManager = navigationManager
                    )
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier, navController: NavHostController,navigationManager: NavigationManager) {
    // Observe cross-module navigation events
    LaunchedEffect(Unit) {
        navigationManager.events.collect { event ->
            when (event) {
                is NavigationEvent.NavigateTo -> {
                    navController.navigate(event.route)
                }
                is NavigationEvent.NavigateAndClear -> {
                    navController.navigate(event.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
                is NavigationEvent.NavigateUp -> {
                    navController.navigateUp()
                }
            }
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoute.OnBoardingGraph
    ) {
        onBoardingGraph(navController,navigationManager)
        authGraph(navController)
    }
}
