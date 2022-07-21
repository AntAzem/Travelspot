package net.barrage.travelspot.screens.trips_list.domain.abstraction

import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest
import net.barrage.travelspot.screens.trips_list.domain.entities.TripsListEntity

interface TripsListRepositoryContract {
    fun fetchTripsList(header: Map<String, String>, body: TripsListRequest): Single<List<TripsListEntity>>
}