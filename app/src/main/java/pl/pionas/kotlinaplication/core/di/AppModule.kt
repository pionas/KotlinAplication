package pl.pionas.kotlinaplication.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.dsl.module

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */

val appModule = module {
    single {
        LinearLayoutManager(get())
    }
    single {
        GridLayoutManager(get(), 2)
    }
    single {
        DividerItemDecoration(get(), LinearLayoutManager.VERTICAL)
    }
}