package net.barrage.travelspot.screens.trips_list.data.local.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TripsListModel(
    @PrimaryKey
    @ColumnInfo(name = "Id")
    val id: String,

    @ColumnInfo(name = "CompanyId")
    val companyId: String?,

    @ColumnInfo(name = "End")
    val end: String?,

    @ColumnInfo(name = "Name")
    val name: String?,

    @ColumnInfo(name = "Services")
    val services: String?,

    @ColumnInfo(name = "Start")
    val start: String?,

    @ColumnInfo(name = "Status")
    val status: String?,

    @ColumnInfo(name = "TripId")
    val tripId: String?
) : Parcelable