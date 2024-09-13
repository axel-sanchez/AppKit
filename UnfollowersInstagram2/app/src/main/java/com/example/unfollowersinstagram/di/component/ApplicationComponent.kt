package com.example.unfollowersinstagram.di.component

import com.example.unfollowersinstagram.di.module.ApplicationModule
import com.example.mercadolibreapp.presentation.ui.DetailsFragment
import com.example.mercadolibreapp.presentation.ui.SearchFragment
import dagger.Component
import javax.inject.Singleton

/**
 * @author Axel Sanchez
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{
    fun inject(searchFragment: SearchFragment)
    fun inject(detailsFragment: DetailsFragment)
}