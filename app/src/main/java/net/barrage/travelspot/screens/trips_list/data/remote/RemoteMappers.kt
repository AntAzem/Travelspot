package net.barrage.travelspot.screens.trips_list.data.remote

import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListItem
import net.barrage.travelspot.utils.constants.EMPTY_STRING

fun mapTripsResponseList(
    responseList: List<TripsListItem?>
): List<TripsListModel> {
    return responseList.map {
        mapFromTripsListResponse(it)
    }
}

fun mapFromTripsListResponse(response: TripsListItem?) : TripsListModel {
    return TripsListModel(
        response?.id ?: "0",
        response?.companyId ?: EMPTY_STRING,
        response?.end ?: EMPTY_STRING,
        response?.name ?: EMPTY_STRING,
        response?.services ?: EMPTY_STRING,
        response?.start ?: EMPTY_STRING,
        response?.status ?: EMPTY_STRING,
        response?.tripId ?: EMPTY_STRING,
    )
}