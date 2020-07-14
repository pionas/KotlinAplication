package pl.pionas.kotlinaplication.core.di

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.dsl.module

/**
 * Created by Adrian Pionka on 14 lipiec 2020
 * adrian@pionka.com
 */
val databaseModule = module {
    single {
        Room.databaseBuilder(get(), RoomDatabase::class.java, "kotlin_application.db")
            .build()
    }
}