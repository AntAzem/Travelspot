package net.barrage.travelspot.screens.login.domain.use_cases

import net.barrage.travelspot.core.use_cases.SingleUseCase
import net.barrage.travelspot.screens.login.domain.abstraction.LoginRepositoryContract
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val contractSteps: LoginRepositoryContract
) : SingleUseCase<LoginEntity>() {

    var loginInformation = mapOf(
        "email" to "azem.zejnilovic@antcolony.io",
        "password" to "Profi2022Profi"
    )

    var header = mapOf("x-timezone" to "Europe/Zagreb")

    fun setup(loginInformation: Map<String, String>, header: Map<String, String>) {
        this.loginInformation = loginInformation
        this.header = header
    }

    override fun buildUseCaseSingle() = contractSteps.fetchLoginData(header, loginInformation)
}