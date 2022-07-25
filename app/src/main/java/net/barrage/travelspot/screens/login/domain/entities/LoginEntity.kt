package net.barrage.travelspot.screens.login.domain.entities

data class LoginEntity(
    val csrf: String? = null,
    val cookie: String? = null
)