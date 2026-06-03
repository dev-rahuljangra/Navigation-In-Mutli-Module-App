package com.devrj.feature_on_boarding.routes

import com.devrj.core_navigation.AppRoute
import kotlinx.serialization.Serializable

sealed interface OnBoardingRoutes : AppRoute{
    @Serializable
    data object ScreenA : OnBoardingRoutes

    @Serializable
    data class ScreenB(val prevScreen: String) : OnBoardingRoutes
}