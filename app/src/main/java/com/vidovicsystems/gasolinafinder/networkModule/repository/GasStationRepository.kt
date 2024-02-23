package com.vidovicsystems.gasolinafinder.networkModule.repository

import com.vidovicsystems.gasolinafinder.model.GasStationList
import com.vidovicsystems.gasolinafinder.model.SingleGasStationModel
import com.vidovicsystems.gasolinafinder.networkModule.GasolinaFinderAPI
import javax.inject.Inject

class GasStationRepository @Inject constructor(private val gasolinaFinderAPI: GasolinaFinderAPI){
    suspend fun getGasStations(): List<GasStationList>?{
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