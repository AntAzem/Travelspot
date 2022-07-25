package net.barrage.travelspot.screens.login.presentation

interface LoginFragmentCallback {
    fun goToTwoFactorAuthenticationScreen(csrf: String? = "", cookie: String? = "")
}