package com.vidovicsystems.gasolinafinder.data.repository

import com.vidovicsystems.gasolinafinder.data.networkModule.GasolinaFinderAPI
import com.vidovicsystems.gasolinafinder.model.GasStationList
import com.vidovicsystems.gasolinafinder.model.SingleGasStationModel
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