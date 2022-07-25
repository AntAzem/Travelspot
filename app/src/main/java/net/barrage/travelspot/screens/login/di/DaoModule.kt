package net.barrage.travelspot.screens.login.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.core.database.DataBase

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun getLoginDao(database: DataBase) = database.loginDao()
}