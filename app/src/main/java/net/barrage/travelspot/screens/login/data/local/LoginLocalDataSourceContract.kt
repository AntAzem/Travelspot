package net.barrage.travelspot.screens.login.data.local

import io.reactivex.Completable
import io.reactivex.Single
import net.barrage.travelspot.screens.login.data.local.models.LoginModel

interface LoginLocalDataSourceContract {
    fun loadLoginData(): Single<LoginModel>

    fun saveLoginData(model: LoginModel): Completable

    fun removeLoginData(): Completable
}
