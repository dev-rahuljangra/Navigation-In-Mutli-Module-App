package com.devrj.feature_auth.routes


import com.devrj.core_navigation.AppRoute
import kotlinx.serialization.Serializable

sealed interface AuthRoutes: AppRoute {
    @Serializable
    data object ScreenA : AuthRoutes

    @Serializable
    data class ScreenB(val prevScreen: String) : AuthRoutes
}