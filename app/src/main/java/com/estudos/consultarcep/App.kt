package com.estudos.consultarcep

import android.app.Application
import com.estudos.consultarcep.data.di.DataModule
import com.estudos.consultarcep.domain.di.DomainModule
import com.estudos.consultarcep.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DomainModule.load()
        DataModule.load()
        PresentationModule.load()
    }
}