package pl.pionas.kotlinaplication.core.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.pionas.kotlinaplication.BuildConfig
import pl.pionas.kotlinaplication.core.api.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Adrian Pionka on 13 lipiec 2020
 * adrian@pionka.com
 */

val networkModule = module {

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single {
        get<Retrofit>().create(RickAndMortyApi::class.java)
    }
}