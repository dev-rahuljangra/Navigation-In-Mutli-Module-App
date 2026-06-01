package com.devrj.feature_auth.routes

import kotlinx.serialization.Serializable

internal sealed interface AuthRoutes {
    @Serializable
    data object ScreenA : AuthRoutes

    @Serializable
    data class ScreenB(val prevScreen: String) : AuthRoutes
}