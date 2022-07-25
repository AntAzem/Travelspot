package net.barrage.travelspot.screens.trips_list.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListResponse
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface TripsListService {

    @POST("v1/bookings")
    fun getBookingListGRID(
        @HeaderMap
        headers: Map<String, String>,
        @Body
        body: TripsListRequest
    ): Single<TripsListResponse?>
}