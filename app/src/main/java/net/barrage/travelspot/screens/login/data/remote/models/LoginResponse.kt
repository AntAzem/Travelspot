package net.barrage.travelspot.screens.login.data.remote.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    val csrf: String,
    val cookie: String,
    val success: Boolean
) : Parcelable