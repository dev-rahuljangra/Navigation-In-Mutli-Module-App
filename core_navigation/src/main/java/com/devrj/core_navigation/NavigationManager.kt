package com.devrj.core_navigation

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NavigationManager @Inject constructor(){
    private val _events = MutableSharedFlow<NavigationEvent>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val events = _events.asSharedFlow()

    // Navigate to a feature ROOT (the only thing core knows about)
    fun navigateTo(route: Any) {
        _events.tryEmit(NavigationEvent.NavigateTo(route))
    }
    fun navigateAndClear(route: Any) {
        _events.tryEmit(NavigationEvent.NavigateAndClear(route))
    }
    fun navigateUp() {
        _events.tryEmit(NavigationEvent.NavigateUp)
    }

}
sealed class NavigationEvent {
    data class NavigateTo(val route: Any) : NavigationEvent()
    data class NavigateAndClear(val route: Any) : NavigationEvent()
    object NavigateUp : NavigationEvent()
}
