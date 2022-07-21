package net.barrage.travelspot.core.root_di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.core.database.DataBase
import net.barrage.travelspot.utils.constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): DataBase {
        var databaseBuilder = Room.databaseBuilder(
            application,
            DataBase::class.java,
            DATABASE_NAME
        )

        return databaseBuilder.fallbackToDestructiveMigration().build()
    }
}