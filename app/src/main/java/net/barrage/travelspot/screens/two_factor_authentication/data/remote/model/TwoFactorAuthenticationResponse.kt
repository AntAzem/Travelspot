package net.barrage.travelspot.screens.two_factor_authentication.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TwoFactorAuthenticationResponse(
    val success: Boolean
) : Parcelable