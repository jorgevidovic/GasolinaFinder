package com.vidovicsystems.gasolinafinder.model

data class PriceModel(
    val count: Int,
    val result: List<PriceList>
)

data class PriceList(
    val Dirección: String,
    val Horario: String,
    val Provincia: String,
    val Localidad: String,
    val Municipio: String,
    val Precio_x0020_Gasolina_x0020_95_x0020_E10: String,
    val Precio_x0020_Gasoleo_x0020_A: String
)