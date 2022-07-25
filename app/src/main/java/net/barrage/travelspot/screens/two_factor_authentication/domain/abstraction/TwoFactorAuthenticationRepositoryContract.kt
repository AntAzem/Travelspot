package net.barrage.travelspot.screens.two_factor_authentication.domain.abstraction

import io.reactivex.Single
import net.barrage.travelspot.screens.two_factor_authentication.domain.entities.TwoFactorAuthenticationEntity

interface TwoFactorAuthenticationRepositoryContract {
    fun checkTwoFactorAuthentication(header: Map<String, String>, token: Map<String, String>): Single<TwoFactorAuthenticationEntity>
}