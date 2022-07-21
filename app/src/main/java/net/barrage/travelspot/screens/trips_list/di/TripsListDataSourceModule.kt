package net.barrage.travelspot.screens.trips_list.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.screens.trips_list.data.local.TripsListLocalDataSource
import net.barrage.travelspot.screens.trips_list.data.local.TripsListLocalDataSourceContract
import net.barrage.travelspot.screens.trips_list.data.local.daos.TripsListDao
import net.barrage.travelspot.screens.trips_list.data.remote.TripsListRemoteDataSource
import net.barrage.travelspot.screens.trips_list.data.remote.TripsListRemoteDataSourceContract
import net.barrage.travelspot.screens.trips_list.data.remote.TripsListService
import net.barrage.travelspot.screens.trips_list.data.repository.TripsListRepository
import net.barrage.travelspot.screens.trips_list.domain.abstraction.TripsListRepositoryContract

@Module
@InstallIn(SingletonComponent::class)
object TripsListDataSourceModule {

    @Provides
    fun provideTripsListRepository(
        remoteDataSourceContract: TripsListRemoteDataSourceContract,
        localDataSourceContract: TripsListLocalDataSourceContract
    ): TripsListRepositoryContract =
        TripsListRepository(remoteDataSourceContract, localDataSourceContract)

    @Provides
    fun provideTripsListRemoteDataSource(
        service: TripsListService
    ): TripsListRemoteDataSourceContract = TripsListRemoteDataSource(service)

    @Provides
    fun provideTripsListLocalDataSource(
        dao: TripsListDao
    ): TripsListLocalDataSourceContract = TripsListLocalDataSource(dao)
}