package net.barrage.travelspot.screens.two_factor_authentication.domain.use_cases

import net.barrage.travelspot.core.use_cases.SingleUseCase
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity
import net.barrage.travelspot.screens.two_factor_authentication.domain.abstraction.TwoFactorAuthenticationRepositoryContract
import net.barrage.travelspot.screens.two_factor_authentication.domain.entities.TwoFactorAuthenticationEntity
import javax.inject.Inject

class CheckTwoFactorAuthenticationUseCase @Inject constructor(
    private val contractSteps: TwoFactorAuthenticationRepositoryContract
) : SingleUseCase<TwoFactorAuthenticationEntity>() {

    var token: Map<String, String> = mapOf()
    var header: Map<String, String> = mapOf()

    fun setup(headerCsrf: String, cookie: String, token: String):CheckTwoFactorAuthenticationUseCase  {
        this.header = mapOf(
            "X-CSRF-TOKEN" to headerCsrf,
            "Cookie" to cookie
        )
        this.token = mapOf(
            "token" to token
        )
        println("hahaha twofactor token $token")
        println("hahaha twofactor CSRF $headerCsrf")
        println("hahaha twofactor Cookie $cookie")
        return this
    }

    override fun buildUseCaseSingle() = contractSteps.checkTwoFactorAuthentication(header, token)
}