package net.barrage.travelspot.screens.two_factor_authentication.data.remote

class TwoFactorAuthenticationDataSource(
    private val service: TwoFactorAuthenticationService
) : TwoFactorAuthenticationDataSourceContract {

    override fun checkTwoFactorAuthentication(header: Map<String, String>, token: Map<String, String>) =
        service.checkTwoFactorAuthentication(header, token)
}