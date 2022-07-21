package net.barrage.travelspot.screens.trips_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.barrage.travelspot.core.CoreFragment
import net.barrage.travelspot.databinding.FragmentTripsListBinding

@AndroidEntryPoint
class TripsListFragment : CoreFragment() {

    private var binding: FragmentTripsListBinding? = null
    private val viewModel: TripsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTripsListBinding.inflate(inflater, container, false)
        binding?.data = viewModel
        return binding?.root
    }
}