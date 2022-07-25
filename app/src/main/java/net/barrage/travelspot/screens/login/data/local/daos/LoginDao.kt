package net.barrage.travelspot.screens.login.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import net.barrage.travelspot.screens.login.data.local.models.LoginModel
import net.barrage.travelspot.screens.trips_list.data.local.models.TripsListModel

@Dao
interface LoginDao {
    @Query("SELECT * FROM LoginModel")
    fun loadLoginData(): Single<LoginModel>

    @Insert(entity = LoginModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveLoginData(model: LoginModel): Completable

    @Query("DELETE FROM LoginModel")
    fun removeLoginData(): Completable
}