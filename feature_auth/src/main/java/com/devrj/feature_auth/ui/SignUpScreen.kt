package com.devrj.feature_auth.ui

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
import com.devrj.core_navigation.AppNavController
import com.devrj.core_navigation.AppRoute

@Composable
fun SignUpScreen(navController: AppNavController) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SignUpScreen Screen",
            modifier = Modifier
        )

        Button(modifier = Modifier.padding(top = 20.dp), onClick = {
            navController.navigateTo(AppRoute.Home.Graph)
        }) {
            Text(
                text = "Navigate to Home",
            )
        }

    }
}