package com.vidovicsystems.gasolinafinder.domain

import com.vidovicsystems.gasolinafinder.data.networkModule.Constants.Companion.BASE_URL
import com.vidovicsystems.gasolinafinder.data.networkModule.GasolinaFinderAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesGasolinaFinderAPI(retrofit: Retrofit): GasolinaFinderAPI {
       return retrofit.create(GasolinaFinderAPI::class.java)
    }
}