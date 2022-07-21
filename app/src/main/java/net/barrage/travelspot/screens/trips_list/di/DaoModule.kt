package net.barrage.travelspot.screens.trips_list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.core.database.DataBase

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun getTripsListDao(database: DataBase) = database.tripsListDao()
}