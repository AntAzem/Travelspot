package net.barrage.travelspot.screens.trips_list.data.remote

import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest

class TripsListRemoteDataSource(
    private val service: TripsListService
) : TripsListRemoteDataSourceContract {

    override fun fetchTripsList(header: Map<String, String>, body: TripsListRequest) =
        service.getBookingListGRID(header, body)
}