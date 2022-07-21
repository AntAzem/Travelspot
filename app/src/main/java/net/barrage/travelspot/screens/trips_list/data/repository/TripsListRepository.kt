package net.barrage.travelspot.screens.trips_list.data.repository

import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.local.TripsListLocalDataSourceContract
import net.barrage.travelspot.screens.trips_list.data.local.mapTripsModelList
import net.barrage.travelspot.screens.trips_list.data.remote.TripsListRemoteDataSourceContract
import net.barrage.travelspot.screens.trips_list.data.remote.mapTripsResponseList
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListItem
import net.barrage.travelspot.screens.trips_list.domain.abstraction.TripsListRepositoryContract
import net.barrage.travelspot.screens.trips_list.domain.entities.TripsListEntity

class TripsListRepository(
    private val remoteDataSource: TripsListRemoteDataSourceContract,
    private val localDataSource: TripsListLocalDataSourceContract
) : TripsListRepositoryContract {

    override fun fetchTripsList(header: Map<String, String>, body: TripsListRequest): Single<List<TripsListEntity>> {
        return remoteDataSource.fetchTripsList(header, body)
            .flatMap { saveAndLoadTripsList(it.rows) }
    }

    private fun saveAndLoadTripsList(tripsList: List<TripsListItem?>): Single<List<TripsListEntity>> {
        val tripsModelList = mapTripsResponseList(tripsList)
        return localDataSource
            .removeTripsList()
            .andThen(localDataSource.saveTripsList(tripsModelList))
            .andThen(
                localDataSource.loadTripsList().map {
                    mapTripsModelList(it)
                }
            )
    }
}