package pl.pionas.kotlinaplication.core.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.pionas.kotlinaplication.BuildConfig
import pl.pionas.kotlinaplication.core.api.Api
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
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'").setPrettyPrinting().create()
        Retrofit.Builder()
            .baseUrl("http://konki.pionas.info/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get<OkHttpClient>())
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }
}