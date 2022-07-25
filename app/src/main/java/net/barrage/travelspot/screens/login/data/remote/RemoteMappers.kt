package net.barrage.travelspot.screens.login.data.remote

import net.barrage.travelspot.screens.login.data.local.models.LoginModel
import net.barrage.travelspot.screens.login.data.remote.models.LoginResponse
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel
import net.barrage.travelspot.screens.trips_list.data.remote.models.TripsListItem
import net.barrage.travelspot.utils.constants.EMPTY_STRING

fun mapFromLoginResponse(response: LoginResponse?, cookie: String?): LoginModel {
    return LoginModel(
        response?.csrf ?: "",
        cookie ?: ""
    )
}