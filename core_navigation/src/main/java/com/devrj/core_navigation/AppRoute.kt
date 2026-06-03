package com.devrj.core_navigation

import kotlinx.serialization.Serializable

/**
 * Root contract for all traversable destinations
 */
interface AppRoute {

    @Serializable
    sealed interface Auth : AppRoute{
        @Serializable object Graph : Auth
        @Serializable object Login : Auth
    }
    @Serializable
    sealed interface OnBoarding : AppRoute {
        @Serializable object Graph : Home
    }

    @Serializable
    sealed interface Home : AppRoute {
        @Serializable object Graph : Home
        @Serializable object Screen : Home
    }

    @Serializable
    sealed interface Hotel : AppRoute {
        @Serializable object Graph : Hotel
        @Serializable object Home : Hotel
        
        // Publicly exposed because Home needs to deep-link directly here
        @Serializable data class Details(val hotelId: String) : Hotel
    }

    @Serializable
    sealed interface Flight : AppRoute {
        @Serializable object Graph : Flight
        @Serializable object Home : Flight
        
        // Publicly exposed for direct search execution from the Dashboard
        @Serializable data class SearchResult(val departure: String, val destination: String) : Flight
    }
}