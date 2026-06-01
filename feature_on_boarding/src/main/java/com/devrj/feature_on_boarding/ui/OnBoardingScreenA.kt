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
import com.devrj.feature_on_boarding.routes.OnBoardingRoutes

@Composable
fun OnBoardingScreenA(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "OnBoarding Screen A",
            modifier = Modifier
        )

        Button(modifier = Modifier.padding(top = 20.dp), onClick = {
            navController.navigate(OnBoardingRoutes.ScreenB(prevScreen = "Screen A"))
        }) {
            Text(
                text = "Navigate to Screen B",
            )
        }

    }

}
