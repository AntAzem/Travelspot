package net.barrage.travelspot.screens.two_factor_authentication.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.model.TwoFactorAuthenticationResponse

interface TwoFactorAuthenticationDataSourceContract {
    fun checkTwoFactorAuthentication(header: Map<String, String>, token: Map<String, String>): Single<TwoFactorAuthenticationResponse?>
}
