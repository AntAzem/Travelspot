package net.barrage.travelspot.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class RoomTypeConverters {

    @TypeConverter
    fun fromTimeStamp(value: Long?) = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimeStamp(date: Date?) = date?.time

    @TypeConverter
    fun fromListOfStrings(list: List<String>?) = list?.joinToString { "," }


    @TypeConverter
    fun toListOfStrings(string: String?) = string?.split(",")

    @TypeConverter
    fun fromMapArray(map: Map<String?, Any?>?): String? {
        map ?: return null
        val type = object : TypeToken<Map<String?, Any?>?>() {}.type
        return Gson().toJson(map, type)
    }

    @TypeConverter
    fun toMapOfAny(mapString: String?): Map<String?, Any?>? {
        mapString ?: return null
        val type = object : TypeToken<Map<String?, Any?>?>() {}.type
        return Gson().fromJson<Map<String?, Any?>?>(mapString, type)
    }
}