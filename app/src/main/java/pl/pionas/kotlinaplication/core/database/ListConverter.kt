package pl.pionas.kotlinaplication.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Adrian Pionka on 21 sierpień 2020
 * adrian@pionka.com
 */
class ListConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toJson(data: List<String>): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): List<String> {
            return Gson().fromJson(json, object : TypeToken<List<String>>() {}.type)
        }
    }
}