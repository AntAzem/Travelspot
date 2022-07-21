package net.barrage.travelspot.screens.trips_list.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel

@Dao
interface TripsListDao {
    @Query("SELECT * FROM TripsListModel")
    fun loadTripsList(): Single<List<TripsListModel>>

    @Insert(entity = TripsListModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveTripsList(model: List<TripsListModel>): Completable

    @Query("DELETE FROM TripsListModel")
    fun removeTripsList(): Completable
}