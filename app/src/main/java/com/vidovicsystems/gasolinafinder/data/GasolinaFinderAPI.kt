package com.vidovicsystems.gasolinafinder.data

import com.vidovicsystems.gasolinafinder.model.PriceModel
import com.vidovicsystems.gasolinafinder.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface GasolinaFinderAPI {
    @GET(ENDPOINT)
    suspend fun getPrices(): Response<PriceModel>
}
