package net.barrage.travelspot.screens.trips_list.data.local

import io.reactivex.Completable
import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.local.daos.TripsListDao
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel

class TripsListLocalDataSource(
    private val dao: TripsListDao
) : TripsListLocalDataSourceContract {
    override fun loadTripsList() = dao.loadTripsList()

    override fun saveTripsList(model: List<TripsListModel>) = dao.saveTripsList(model)

    override fun removeTripsList() = dao.removeTripsList()
}