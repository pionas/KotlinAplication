package pl.pionas.kotlinaplication.core.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.pionas.kotlinaplication.core.di.koinInjector

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        statKoin()
    }

    private fun statKoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjector)
        }
    }
}