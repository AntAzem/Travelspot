package net.barrage.travelspot.screens.trips_list.data.local

import io.reactivex.Completable
import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel

interface TripsListLocalDataSourceContract {

    fun loadTripsList(): Single<List<TripsListModel>>

    fun saveTripsList(model: List<TripsListModel>): Completable

    fun removeTripsList(): Completable
}