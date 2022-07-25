package net.barrage.travelspot.screens.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.barrage.travelspot.R
import net.barrage.travelspot.core.CoreFragment
import net.barrage.travelspot.databinding.FragmentLoginBinding
import net.barrage.travelspot.utils.navigation.ARG_COOKIE
import net.barrage.travelspot.utils.navigation.ARG_CSRF

@AndroidEntryPoint
class LoginFragment: CoreFragment(), LoginFragmentCallback {

    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.callback = this
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding?.data = viewModel
        return binding?.root
    }

    override fun goToTwoFactorAuthenticationScreen(csrf: String?, cookie: String?) {
        navControllerNavigate(
            R.id.action_loginFragment_to_twoFactorAuthenticationFragment,
            bundleOf(
                ARG_CSRF to csrf,
                ARG_COOKIE to cookie
            )
        )
    }
}