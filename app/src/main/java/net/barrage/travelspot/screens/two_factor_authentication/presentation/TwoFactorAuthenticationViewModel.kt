package net.barrage.travelspot.screens.two_factor_authentication.presentation

import androidx.databinding.Bindable
import dagger.hilt.android.lifecycle.HiltViewModel
import net.barrage.travelspot.core.CoreViewModel
import net.barrage.travelspot.screens.two_factor_authentication.domain.entities.TwoFactorAuthenticationEntity
import net.barrage.travelspot.screens.two_factor_authentication.domain.use_cases.CheckTwoFactorAuthenticationUseCase
import net.barrage.travelspot.utils.constants.EMPTY_STRING
import javax.inject.Inject
import kotlin.properties.Delegates
import androidx.databinding.library.baseAdapters.BR

@HiltViewModel
class TwoFactorAuthenticationViewModel @Inject constructor(
    private val twoFactorAuthenticationUseCase: CheckTwoFactorAuthenticationUseCase
) : CoreViewModel() {

    var csrf = ""
    var cookie = ""

    @get:Bindable
    var twoFactorAuthenticationCode by Delegates.observable(EMPTY_STRING) { _, _, _ -> notifyPropertyChanged(BR.twoFactorAuthenticationCode)}

    init {

    }

    fun submitTwoFactorAuthentication() {
        twoFactorAuthenticationUseCase.setup(csrf, cookie, twoFactorAuthenticationCode)
            .execute(object : CoreSingleObserver<TwoFactorAuthenticationEntity>() {
                override fun onSuccess(t: TwoFactorAuthenticationEntity) {
                    println("hahaha $t")
                }

                override fun onError(e: Throwable) {
                    println("hahaha $e")
                }
        })
    }
}