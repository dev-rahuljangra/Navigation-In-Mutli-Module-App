package com.devrj.feature_on_boarding.routes

import kotlinx.serialization.Serializable

internal sealed interface OnBoardingRoutes {
    @Serializable
    data object ScreenA : OnBoardingRoutes

    @Serializable
    data class ScreenB(val prevScreen: String) : OnBoardingRoutes
}