package net.barrage.travelspot.screens.trips_list.domain.entities

data class TripsListEntity (
    val companyId: String? = null,
    var end: String? = null,
    val id: String,
    val name: String? = null,
    val services: String? = null,
    val start: String? = null,
    val status: String? = null,
    val tripId: String? = null,
)