package net.barrage.travelspot.screens.two_factor_authentication.data.repository

import io.reactivex.Single
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.TwoFactorAuthenticationDataSourceContract
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.mapFromTwoFactorAuthenticationResponse
import net.barrage.travelspot.screens.two_factor_authentication.domain.abstraction.TwoFactorAuthenticationRepositoryContract
import net.barrage.travelspot.screens.two_factor_authentication.domain.entities.TwoFactorAuthenticationEntity

class TwoFactorAuthenticationRepository(
    private val remoteDataSource: TwoFactorAuthenticationDataSourceContract
) : TwoFactorAuthenticationRepositoryContract {

    override fun checkTwoFactorAuthentication(header: Map<String, String>, token: Map<String, String>): Single<TwoFactorAuthenticationEntity> {
        return remoteDataSource.checkTwoFactorAuthentication(header, token)
            .map { mapFromTwoFactorAuthenticationResponse(it) }
    }
}