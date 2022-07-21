package net.barrage.travelspot.screens.trips_list.domain.use_cases

import net.barrage.travelspot.core.use_cases.SingleUseCase
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListRequest
import net.barrage.travelspot.screens.trips_list.domain.abstraction.TripsListRepositoryContract
import net.barrage.travelspot.screens.trips_list.domain.entities.TripsListEntity
import javax.inject.Inject

class FetchTripsListUseCase @Inject constructor(
    private val contractSteps: TripsListRepositoryContract
) : SingleUseCase<List<TripsListEntity>>() {

    private var header: Map<String, String> = mapOf(
        "X-CSRF-TOKEN" to "ccd2b35a-2d4c-4cb1-8ca3-644eacedd94f",
        "Content-Type" to "application/json",
        "Cookie" to "travelspot-public-app=62d91180dad2d303df3c0003"
    )

    private var body: TripsListRequest = TripsListRequest(
        1,
        100,
        listOf("booked", "pending", "canceled", "finished")
    )

    fun setup(header: Map<String, String>, body: TripsListRequest) {
        this.header = header
        this.body = body
    }

    override fun buildUseCaseSingle() = contractSteps.fetchTripsList(header, body)
}