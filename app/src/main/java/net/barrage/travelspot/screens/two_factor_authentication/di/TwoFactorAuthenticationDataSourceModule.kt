package net.barrage.travelspot.screens.two_factor_authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.TwoFactorAuthenticationDataSource
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.TwoFactorAuthenticationDataSourceContract
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.TwoFactorAuthenticationService
import net.barrage.travelspot.screens.two_factor_authentication.data.repository.TwoFactorAuthenticationRepository
import net.barrage.travelspot.screens.two_factor_authentication.domain.abstraction.TwoFactorAuthenticationRepositoryContract

@Module
@InstallIn(SingletonComponent::class)
object TwoFactorAuthenticationDataSourceModule {

    @Provides
    fun provideTwoFactorAuthenticationRepository(
        remoteDataSourceContract: TwoFactorAuthenticationDataSourceContract
    ): TwoFactorAuthenticationRepositoryContract =
        TwoFactorAuthenticationRepository(remoteDataSourceContract)

    @Provides
    fun provideTwoFactorAuthenticationRemoteDataSource(
        service: TwoFactorAuthenticationService
    ): TwoFactorAuthenticationDataSourceContract = TwoFactorAuthenticationDataSource(service)
}
