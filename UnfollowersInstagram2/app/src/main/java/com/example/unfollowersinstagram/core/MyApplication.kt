package com.example.unfollowersinstagram.core

import android.app.Application
import com.example.unfollowersinstagram.di.component.ApplicationComponent
import com.example.unfollowersinstagram.di.component.DaggerApplicationComponent
import com.example.unfollowersinstagram.di.module.ApplicationModule

/**
 * @author Axel Sanchez
 */
class MyApplication: Application() {
    val component: ApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
}