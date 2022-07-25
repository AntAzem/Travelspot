package net.barrage.travelspot.screens.login.data.remote

class LoginRemoteDataSource(
    private val service: LoginService
) : LoginRemoteDataSourceContract {

    override fun loginUser(header: Map<String, String>, loginInformation: Map<String, String>) =
        service.loginUser(header, loginInformation)
}