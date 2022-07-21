package net.barrage.travelspot.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.barrage.travelspot.screens.trips_list.data.local.daos.TripsListDao
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel

@Database(
    entities = [
        TripsListModel::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    RoomTypeConverters::class
)

abstract class DataBase: RoomDatabase() {
    abstract fun tripsListDao(): TripsListDao
}