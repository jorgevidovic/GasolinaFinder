package com.vidovicsystems.gasolinafinder.model

data class GasStationModel(
    val Fecha: String,
    val Nota: String,
    val ResultadoConsulta: String,
    val ListaEESSPrecio: List<GasStationList>
)

data class GasStationList(
    //val `C.P.`: String,
    val Dirección: String,
    val Horario: String,
    val Latitud: String,
    val Localidad: String,
    val `Longitud_x0020__x0028_WGS84_x0029_`: String,
    val Margen: String,
    val Municipio: String,
    val Precio_x0020_Biodiesel: String,
    val Precio_x0020_Bioetanol: String,
    val Precio_x0020_Gas_x0020_Natural_x0020_Comprimido: String,
    val Precio_x0020_Gas_x0020_Natural_x0020_Licuado: String,
    val Precio_x0020_Gases_x0020_licuados_x0020_del_x0020_petróleo: String,
    val Precio_x0020_Gasoleo_x0020_A: String,
    val Precio_x0020_Gasoleo_x0020_B: String,
    val Precio_x0020_Gasoleo_x0020_Premium: String,
    val Precio_x0020_Gasolina_x0020_95_x0020_E10: String,
    val Precio_x0020_Gasolina_x0020_95_x0020_E5: String,
    val Precio_x0020_Gasolina_x0020_95_x0020_E5_x0020_Premium: String,
    val Precio_x0020_Gasolina_x0020_98_x0020_E10: String,
    val Precio_x0020_Gasolina_x0020_98_x0020_E5: String,
    val Precio_x0020_Hidrogeno: String,
    val Provincia: String,
    val Remisión: String,
    val Rótulo: String,
    val Tipo_x0020_Venta: String,
    val `_x0025__x0020_BioEtanol`: String,
    val `_x0025__x0020_Éster_x0020_metílico`: String,
    val IDEESS: String,
    val IDMunicipio: String,
    val IDProvincia: String,
    val IDCCAA: String
)