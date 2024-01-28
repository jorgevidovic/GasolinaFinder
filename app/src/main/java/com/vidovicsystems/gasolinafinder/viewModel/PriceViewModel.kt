package com.vidovicsystems.gasolinafinder.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vidovicsystems.gasolinafinder.model.PriceList
import com.vidovicsystems.gasolinafinder.repository.PriceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PriceViewModel @Inject constructor(private val repository: PriceRepository) : ViewModel() {
    private val _prices = MutableStateFlow<List<PriceList>>(emptyList())
    val prices = _prices.asStateFlow()

    init {
        fetchPrices()
    }

    private fun fetchPrices() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getPrices()
                _prices.value = result ?: emptyList()
            }
        }
    }
}