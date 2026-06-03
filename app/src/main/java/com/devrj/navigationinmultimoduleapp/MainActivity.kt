package com.devrj.navigationinmultimoduleapp

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
import com.devrj.core_navigation.AppNavController
import com.devrj.core_navigation.AppRoute
import com.devrj.core_navigation.NavigationEvent
import com.devrj.design_system.theme.NavigationInMultiModuleAppTheme
import com.devrj.feature_auth.navgraph.authGraph
import com.devrj.feature_home.homeGraph
import com.devrj.feature_on_boarding.navgraph.onBoardingGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavController: AppNavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationInMultiModuleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding),
                        appNavController = appNavController
                    )
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier, appNavController: AppNavController) {
    // Observe cross-module navigation events
    val navController = rememberNavController()
    NavigationObserver(navController = navController, appNavController = appNavController)

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoute.OnBoarding.Graph
    ) {
        onBoardingGraph(appNavController)
        authGraph(appNavController)
        homeGraph(appNavController)
    }
}

@Composable
fun NavigationObserver(
    navController: NavHostController,
    appNavController: AppNavController
) {
    // Listens to commands coming from feature modules and executes them on the NavController
    LaunchedEffect(Unit) {
        appNavController.navigationCommands.collect { command ->
            when (command) {
                is NavigationEvent.Back -> navController.popBackStack()
                is NavigationEvent.To -> {
                    navController.navigate(command.route) {
                        command.options?.let { options ->
                            launchSingleTop = options.launchSingleTop
                            options.popUpToRoute?.let { popRoute ->
                                popUpTo(popRoute) { inclusive = options.inclusive }
                            }
                        }
                    }
                }
            }
        }
    }
}