package net.barrage.travelspot.screens.trips_list.data.local

import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel
import net.barrage.travelspot.screens.trips_list.domain.entities.TripsListEntity

fun mapTripsModelList(modelList: List<TripsListModel>) =
    modelList.mapNotNull { mapToTripsListEntity(it) }

fun mapToTripsListEntity(model: TripsListModel) =
    TripsListEntity(
        companyId = model.companyId,
        end = model.end,
        id = model.id,
        name = model.name,
        services = model.services,
        start = model.start,
        status = model.status,
        tripId = model.tripId
    )