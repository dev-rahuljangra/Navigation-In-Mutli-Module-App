package com.devrj.navigationinmultimoduleapp

import com.devrj.core_navigation.AppNavController
import com.devrj.core_navigation.AppNavControllerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideAppNavigator(): AppNavController {
        return AppNavControllerImpl()
    }
}