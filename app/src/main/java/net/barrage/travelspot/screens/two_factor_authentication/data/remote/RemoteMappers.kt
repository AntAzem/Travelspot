package net.barrage.travelspot.screens.two_factor_authentication.data.remote

import net.barrage.travelspot.screens.two_factor_authentication.data.remote.model.TwoFactorAuthenticationResponse
import net.barrage.travelspot.screens.two_factor_authentication.domain.entities.TwoFactorAuthenticationEntity

fun mapFromTwoFactorAuthenticationResponse(response: TwoFactorAuthenticationResponse?): TwoFactorAuthenticationEntity {
    return TwoFactorAuthenticationEntity(
        response?.success ?: false
    )
}