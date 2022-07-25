package net.barrage.travelspot.screens.login.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import net.barrage.travelspot.core.CoreViewModel
import net.barrage.travelspot.screens.login.domain.entities.LoginEntity
import net.barrage.travelspot.screens.login.domain.use_cases.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : CoreViewModel() {

    var callback: LoginFragmentCallback? = null

    init {
        loginUseCase.execute(object : CoreSingleObserver<LoginEntity>() {
            override fun onSuccess(t: LoginEntity) {
                println("hahaha loginEntity $t")
                callback?.goToTwoFactorAuthenticationScreen(t.csrf, t.cookie)
            }

            override fun onError(e: Throwable) {
                println("hahaha $e")
            }
        })
    }
}