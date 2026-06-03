package com.devrj.core_navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow


sealed class NavigationEvent{
    data class To(val route: AppRoute, val options: CustomNavOptions? = null) : NavigationEvent()
    object Back : NavigationEvent()
}



interface AppNavController {
    val navigationCommands: SharedFlow<NavigationEvent>
    fun navigateTo(route: AppRoute, options: CustomNavOptions? = null)
    fun popBackStack()
}
class AppNavControllerImpl : AppNavController {
    private val _navigationCommands = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    override val navigationCommands = _navigationCommands.asSharedFlow()

    override fun navigateTo(route: AppRoute, options: CustomNavOptions?) {
        _navigationCommands.tryEmit(NavigationEvent.To(route, options))
    }

    override fun popBackStack() {
        _navigationCommands.tryEmit(NavigationEvent.Back)
    }
}
data class CustomNavOptions(
    val popUpToRoute: AppRoute? = null,
    val inclusive: Boolean = false,
    val launchSingleTop: Boolean = false
)

