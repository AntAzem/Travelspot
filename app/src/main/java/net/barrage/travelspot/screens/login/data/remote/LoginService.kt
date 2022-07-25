package net.barrage.travelspot.screens.login.data.remote

import io.reactivex.Single
import net.barrage.travelspot.screens.login.data.remote.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface LoginService {

    @POST("v1/auth/login")
    fun loginUser(
        @HeaderMap header: Map<String, String>,
        @Body loginInformation: Map<String, String>
    ): Single<Response<LoginResponse?>?>
}