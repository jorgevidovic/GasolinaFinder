package com.vidovicsystems.gasolinafinder.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vidovicsystems.gasolinafinder.model.GasStationList
import com.vidovicsystems.gasolinafinder.data.repository.GasStationRepository
import com.vidovicsystems.gasolinafinder.state.GasStationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GasStationViewModel @Inject constructor(private val repository: GasStationRepository) : ViewModel() {
    private val _prices = MutableStateFlow<List<GasStationList>>(emptyList())
    val prices = _prices

    var state by mutableStateOf(GasStationState())
        private set
    init {
        fetchPrices()
    }

    private fun fetchPrices() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGasStations()
                _prices.value = result ?: emptyList()
            }
        }
    }

    fun getGasStationByIdLocale(IDEESS: String): GasStationList? {

        return prices.value?.find { it.IDEESS == IDEESS }
    }

    fun getGasStationById(IDEESS: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repository.getGasStationById(IDEESS)
                state = state.copy(
                    IDEESS = result?.IDEESS ?: "",
                    Rótulo = result?.Rótulo ?: "",
                    Dirección = result?.Dirección ?: "",
                    Provincia = result?.Provincia ?: "",
                    Horario = result?.Horario ?: "",
                    Localidad = result?.Localidad ?: "",
                    Margen = result?.Margen ?: "",
                    Municipio = result?.Municipio ?: "",
                    Precio_x0020_Biodiesel = result?.Precio_x0020_Biodiesel ?: "",
                    Precio_x0020_Bioetanol = result?.Precio_x0020_Bioetanol ?: "",
                    Precio_x0020_Gas_x0020_Natural_x0020_Comprimido = result?.Precio_x0020_Gas_x0020_Natural_x0020_Comprimido ?: "",
                    Precio_x0020_Gas_x0020_Natural_x0020_Licuado = result?.Precio_x0020_Gas_x0020_Natural_x0020_Licuado ?: "",
                    Precio_x0020_Gases_x0020_licuados_x0020_del_x0020_petróleo = result?.Precio_x0020_Gases_x0020_licuados_x0020_del_x0020_petróleo ?: "",
                    Precio_x0020_Gasoleo_x0020_A = result?.Precio_x0020_Gasoleo_x0020_A ?: "",
                    Precio_x0020_Gasoleo_x0020_B = result?.Precio_x0020_Gasoleo_x0020_B ?: "",
                    Precio_x0020_Gasoleo_x0020_Premium = result?.Precio_x0020_Gasoleo_x0020_Premium ?: "",
                    Precio_x0020_Gasolina_x0020_95_x0020_E10 = result?.Precio_x0020_Gasolina_x0020_95_x0020_E10 ?: "",
                    Precio_x0020_Gasolina_x0020_95_x0020_E5 = result?.Precio_x0020_Gasolina_x0020_95_x0020_E5 ?: "",
                    Precio_x0020_Gasolina_x0020_95_x0020_E5_x0020_Premium = result?.Precio_x0020_Gasolina_x0020_95_x0020_E5_x0020_Premium ?: "",
                    Precio_x0020_Gasolina_x0020_98_x0020_E10 = result?.Precio_x0020_Gasolina_x0020_98_x0020_E10 ?: "",
                    Precio_x0020_Gasolina_x0020_98_x0020_E5 = result?.Precio_x0020_Gasolina_x0020_98_x0020_E5 ?: "",
                    Precio_x0020_Hidrogeno = result?.Precio_x0020_Hidrogeno ?: ""
                )
            }
        }
    }
}