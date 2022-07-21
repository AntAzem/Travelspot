package net.barrage.travelspot.screens.trips_list.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListResponse

interface TripsListRemoteDataSourceContract {
    fun fetchTripsList(header: Map<String, String>, body: TripsListRequest) : Single<TripsListResponse?>
}