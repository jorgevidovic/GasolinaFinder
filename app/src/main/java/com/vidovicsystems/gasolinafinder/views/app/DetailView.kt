package com.vidovicsystems.gasolinafinder.views.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vidovicsystems.gasolinafinder.components.MainTopBar
import com.vidovicsystems.gasolinafinder.model.GasStationList
import com.vidovicsystems.gasolinafinder.viewModel.GasStationViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(viewModel: GasStationViewModel, navController: NavController, IDEESS: String) {
    val gasStation = viewModel.getGasStationByIdLocale(IDEESS)

    val state by viewModel.prices.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getGasStationById(IDEESS)
    }

    Scaffold(
        topBar = {
            MainTopBar(title = IDEESS, showBackButton = true) {
                navController.popBackStack()
            }
        }
    ) {
        //ContentDetailView(it, viewModel)
        gasStation?.let {
            ContentDetailViewLocale(it, PaddingValues())
        }
    }
}

@Composable
fun ContentDetailViewLocale(gasStation: GasStationList, pad: PaddingValues) {
    Column(modifier = Modifier.padding(pad)) {
        Spacer(modifier = Modifier.height(90.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, end = 50.dp)
        ){
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Icono de ubicación",
                modifier = Modifier.size(100.dp)
            )
        }
        Text(text = "Dirección: ${gasStation.Dirección}")
        Text(text = "Horario: ${gasStation.Horario}")
        Text(text = "Municipio: ${gasStation.Municipio}")
        Text(text = "Provincia: ${gasStation.Provincia}")
        Text(text = "Gasolina 95: ${gasStation.Precio_x0020_Gasolina_x0020_95_x0020_E10}")
        Text(text = "Gasoleo A: ${gasStation.Precio_x0020_Gasoleo_x0020_A}")
        Text(text = "Gasoleo B: ${gasStation.Precio_x0020_Gasoleo_x0020_B}")


    }
}

@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: GasStationViewModel) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ) {
            Text(text = state.Dirección)
            Text(text = state.Horario)
            Text(text = state.Municipio)
        }
    }
}