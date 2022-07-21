package net.barrage.travelspot.screens.trips_list.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import net.barrage.travelspot.core.CoreViewModel
import net.barrage.travelspot.screens.trips_list.domain.entities.TripsListEntity
import net.barrage.travelspot.screens.trips_list.domain.use_cases.FetchTripsListUseCase
import javax.inject.Inject

@HiltViewModel
class TripsListViewModel @Inject constructor(
    private val fetchTripsListUseCase: FetchTripsListUseCase
) : CoreViewModel() {

    init {
        fetchTripsListUseCase.execute(object : CoreSingleObserver<List<TripsListEntity>>() {
            override fun onSuccess(t: List<TripsListEntity>) {
                println("hahaha $t")
            }

            override fun onError(e: Throwable) {
                println("hahaha $e")
            }
        })
    }
}