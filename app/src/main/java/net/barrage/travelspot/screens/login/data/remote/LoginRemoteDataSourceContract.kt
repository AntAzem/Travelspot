package net.barrage.travelspot.screens.login.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.login.data.remote.models.LoginResponse
import retrofit2.Response

interface LoginRemoteDataSourceContract {
    fun loginUser(header: Map<String, String>, loginInformation: Map<String, String>): Single<Response<LoginResponse?>?>
}