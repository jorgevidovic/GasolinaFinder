package com.vidovicsystems.gasolinafinder.data.networkModule

import com.vidovicsystems.gasolinafinder.domain.GasStationModel
import com.vidovicsystems.gasolinafinder.domain.SingleGasStationModel
import com.vidovicsystems.gasolinafinder.data.networkModule.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GasolinaFinderAPI {
    @GET(ENDPOINT)
    suspend fun getGasStations(): Response<GasStationModel>

    // Aquí me gustaría filtrar por provincia y municipio
    @GET("$ENDPOINT/{IDEESS}")
    suspend fun getGasStationById(@Path(value = "IDEESS") IDEESS: String): Response<SingleGasStationModel>

}
