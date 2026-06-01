package com.devrj.feature_on_boarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devrj.core_navigation.NavigationManager

@Composable
fun OnBoardingScreenB(navController: NavController, navigationManager: NavigationManager) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "OnBoarding Screen B",
            modifier = Modifier
        )

        Button(modifier = Modifier.padding(top = 20.dp), onClick = {navigationManager.navigateTo(AppRoute.AuthGraph)}) {
            Text(
                text = "Navigate to Auth Graph",
            )
        }

    }
}