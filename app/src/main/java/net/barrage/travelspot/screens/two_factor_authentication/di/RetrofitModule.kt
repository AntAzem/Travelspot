package net.barrage.travelspot.screens.two_factor_authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.barrage.travelspot.screens.login.data.remote.LoginService
import net.barrage.travelspot.screens.two_factor_authentication.data.remote.TwoFactorAuthenticationService
import net.barrage.travelspot.utils.constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideTwoFactorAuthenticationService() : TwoFactorAuthenticationService {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TwoFactorAuthenticationService::class.java)
    }
}