package net.barrage.travelspot.screens.login.domain.abstraction

import io.reactivex.Single
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity

interface LoginRepositoryContract {
    fun fetchLoginData(header: Map<String, String>, loginInformation: Map<String, String>): Single<LoginEntity>
}