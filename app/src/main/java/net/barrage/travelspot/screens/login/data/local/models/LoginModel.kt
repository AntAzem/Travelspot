package net.barrage.travelspot.screens.login.data.local.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class LoginModel(
    @PrimaryKey
    @ColumnInfo(name = "Csrf")
    val csrf: String,

    @ColumnInfo(name = "Cookie")
    val cookie: String
) : Parcelable