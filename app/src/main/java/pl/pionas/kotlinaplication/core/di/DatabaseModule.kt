package pl.pionas.kotlinaplication.core.di

import androidx.room.Room
import org.koin.dsl.module
import pl.pionas.kotlinaplication.core.database.AppDatabase

/**
 * Created by Adrian Pionka on 14 lipiec 2020
 * adrian@pionka.com
 */
val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "kotlin_application.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().articleDao() }
    single { get<AppDatabase>().userDao() }
}