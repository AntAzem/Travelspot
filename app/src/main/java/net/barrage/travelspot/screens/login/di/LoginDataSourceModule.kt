package net.barrage.travelspot.screens.login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.screens.login.data.local.LoginLocalDataSource
import net.barrage.travelspot.screens.login.data.local.LoginLocalDataSourceContract
import net.barrage.travelspot.screens.login.data.local.daos.LoginDao
import net.barrage.travelspot.screens.login.data.remote.LoginRemoteDataSource
import net.barrage.travelspot.screens.login.data.remote.LoginRemoteDataSourceContract
import net.barrage.travelspot.screens.login.data.remote.LoginService
import net.barrage.travelspot.screens.login.data.repository.LoginRepository
import net.barrage.travelspot.screens.login.domain.abstraction.LoginRepositoryContract

@Module
@InstallIn(SingletonComponent::class)
object LoginDataSourceModule {

    @Provides
    fun provideLoginRepository(
        remoteDataSourceContract: LoginRemoteDataSourceContract,
        localDataSourceContract: LoginLocalDataSourceContract
    ): LoginRepositoryContract =
        LoginRepository(remoteDataSourceContract, localDataSourceContract)

    @Provides
    fun provideLoginRemoteDataSource(
        service: LoginService
    ): LoginRemoteDataSourceContract = LoginRemoteDataSource(service)

    @Provides
    fun provideLoginLocalDataSource(
        dao: LoginDao
    ): LoginLocalDataSourceContract = LoginLocalDataSource(dao)
}
