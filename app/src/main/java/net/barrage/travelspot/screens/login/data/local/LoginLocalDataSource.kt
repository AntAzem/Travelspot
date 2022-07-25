package net.barrage.travelspot.screens.login.data.local

import net.barrage.travelspot.screens.login.data.local.daos.LoginDao
import net.barrage.travelspot.screens.login.data.local.models.LoginModel

class LoginLocalDataSource(
    private val dao: LoginDao
) : LoginLocalDataSourceContract {

    override fun loadLoginData() = dao.loadLoginData()

    override fun saveLoginData(model: LoginModel) = dao.saveLoginData(model)

    override fun removeLoginData() = dao.removeLoginData()
}