package net.barrage.travelspot.screens.trips_list.data.remote.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TripsListItem(
    val companyId: String,
    var end: String,
    val id: String,
    val name: String,
    val services: String,
    val start: String,
    val status: String,
    val tripId: String,
) : Parcelable