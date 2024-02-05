package com.vidovicsystems.gasolinafinder.repository

import com.vidovicsystems.gasolinafinder.data.GasolinaFinderAPI
import com.vidovicsystems.gasolinafinder.model.PriceList
import com.vidovicsystems.gasolinafinder.model.SingleGasStationModel
import javax.inject.Inject

class PriceRepository @Inject constructor(private val gasolinaFinderAPI: GasolinaFinderAPI){
    suspend fun getGasStations(): List<PriceList>?{
        val response = gasolinaFinderAPI.getGasStations()
        if (response.isSuccessful){
            return response.body()?.ListaEESSPrecio
        }
        return null
    }

    suspend fun getGasStationById(IDEESS: String):SingleGasStationModel?{
        val response = gasolinaFinderAPI.getGasStationById(IDEESS)
        if (response.isSuccessful){
            return response.body()
        }
        return null
    }
}