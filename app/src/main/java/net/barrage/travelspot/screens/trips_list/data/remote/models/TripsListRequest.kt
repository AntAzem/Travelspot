package net.barrage.travelspot.screens.trips_list.data.remote.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TripsListRequest(
    val page: Int,
    val perPage: Int,
    val status: List<String>
) : Parcelable