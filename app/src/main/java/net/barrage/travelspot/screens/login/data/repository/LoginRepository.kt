package net.barrage.travelspot.screens.login.data.repository

import io.reactivex.Single
import net.barrage.travelspot.screens.login.data.local.LoginLocalDataSourceContract
import net.barrage.travelspot.screens.login.data.local.mapToLoginDataEntity
import net.barrage.travelspot.screens.login.data.remote.LoginRemoteDataSourceContract
import net.barrage.travelspot.screens.login.data.remote.mapFromLoginResponse
import net.barrage.travelspot.screens.login.data.remote.models.LoginResponse
import net.barrage.travelspot.screens.login.domain.abstraction.LoginRepositoryContract
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity

class LoginRepository(
    private val remoteDataSource: LoginRemoteDataSourceContract,
    private val localDataSource: LoginLocalDataSourceContract
) : LoginRepositoryContract {

    override fun fetchLoginData(header: Map<String, String>, loginInformation: Map<String, String>): Single<LoginEntity> {
        return remoteDataSource.loginUser(header, loginInformation)
            .flatMap {
                val cookie = it.headers()["Set-Cookie"]?.split(";")?.first()
                println("hahaha cookie $cookie")
                saveAndLoadLoginData(it.body(), cookie)
            }
    }

    private fun saveAndLoadLoginData(loginData: LoginResponse?, cookie: String?): Single<LoginEntity> {
        val loginModel = mapFromLoginResponse(loginData, cookie)
        return localDataSource
            .removeLoginData()
            .andThen(localDataSource.saveLoginData(loginModel))
            .andThen(
                localDataSource.loadLoginData().map {
                    mapToLoginDataEntity(it)
                }
            )
    }
}