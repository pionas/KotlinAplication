package pl.pionas.kotlinaplication.core.database

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time?.toLong()
        }

    }
}