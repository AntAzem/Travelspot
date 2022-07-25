package net.barrage.travelspot.screens.two_factor_authentication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import net.barrage.travelspot.core.CoreFragment
import net.barrage.travelspot.databinding.FragmentTwoFactorAuthenticationBinding

@AndroidEntryPoint
class TwoFactorAuthenticationFragment: CoreFragment() {

    private var binding: FragmentTwoFactorAuthenticationBinding? = null
    private val viewModel: TwoFactorAuthenticationViewModel by viewModels()
    private val navArgs: TwoFactorAuthenticationFragmentArgs by navArgs()
    var csrf = ""
    var cookie = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        csrf = navArgs.csrf ?: ""
        cookie = navArgs.cookie ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.csrf = csrf
        viewModel.cookie = cookie
       binding = FragmentTwoFactorAuthenticationBinding.inflate(inflater, container, false)
       binding?.data = viewModel
       return binding?.root
    }
}