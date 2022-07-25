package net.barrage.travelspot.screens.two_factor_authentication.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.model.TwoFactorAuthenticationResponse
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface TwoFactorAuthenticationService {

    @POST("/v1/auth/2fa/validate")
    fun checkTwoFactorAuthentication(
        @HeaderMap
        headers: Map<String, String>,
        @Body
        token: Map<String, String>
    ): Single<TwoFactorAuthenticationResponse?>
}