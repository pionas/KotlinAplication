package pl.pionas.kotlinaplication.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.pionas.kotlinaplication.R
import pl.pionas.kotlinaplication.core.exception.ErrorMapper
import pl.pionas.kotlinaplication.core.exception.ErrorMapperImpl
import pl.pionas.kotlinaplication.core.exception.ErrorWrapper
import pl.pionas.kotlinaplication.core.exception.ErrorWrapperImpl
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigator
import pl.pionas.kotlinaplication.core.navigation.FragmentNavigatorImpl
import pl.pionas.kotlinaplication.core.network.NetworkStateProvider
import pl.pionas.kotlinaplication.core.network.NetworkStateProviderImpl
import pl.pionas.kotlinaplication.core.provider.ActivityProvider

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */

val appModule = module {
    factory {
        LinearLayoutManager(get())
    }
    single {
        GridLayoutManager(get(), 2)
    }
    factory {
        DividerItemDecoration(get(), LinearLayoutManager.VERTICAL)
    }
    single<ErrorWrapper> {
        ErrorWrapperImpl()
    }
    single<ErrorMapper> {
        ErrorMapperImpl(get())
    }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}