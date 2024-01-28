package com.vidovicsystems.gasolinafinder.repository

import com.vidovicsystems.gasolinafinder.data.GasolinaFinderAPI
import com.vidovicsystems.gasolinafinder.model.PriceList
import javax.inject.Inject

class PriceRepository @Inject constructor(private val apiGasolinaFinderAPI: GasolinaFinderAPI){
    suspend fun getPrices(): List<PriceList>?{
        val response = apiGasolinaFinderAPI.getPrices()
        if (response.isSuccessful){
            return response.body()?.ListaEESSPrecio
        }
        return null
    }
}