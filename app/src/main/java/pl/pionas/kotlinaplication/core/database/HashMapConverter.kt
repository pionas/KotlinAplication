package pl.pionas.kotlinaplication.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HashMapConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toJson(data: HashMap<String, String>?): String {
            if (data.isNullOrEmpty()) {
                return ""
            }
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): HashMap<String, String>? {
            if (json.isEmpty()) {
                return null
            }
            return Gson().fromJson(json, object : TypeToken<HashMap<String, String>>() {}.type)
        }
    }
}
