package net.barrage.travelspot.screens.login.data.local

import net.barrage.travelspot.screens.login.data.local.models.LoginModel
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity

fun mapToLoginDataEntity(model: LoginModel) =
    LoginEntity(
        csrf = model.csrf,
        cookie = model.cookie
    )