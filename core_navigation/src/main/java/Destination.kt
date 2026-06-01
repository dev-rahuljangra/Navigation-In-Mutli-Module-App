import kotlinx.serialization.Serializable

sealed interface AppRoute {
    @Serializable
    data object OnBoardingGraph : AppRoute
    @Serializable
    data object AuthGraph : AppRoute
}