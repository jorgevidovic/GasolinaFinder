package com.vidovicsystems.gasolinafinder.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vidovicsystems.gasolinafinder.components.GasStationCard
import com.vidovicsystems.gasolinafinder.components.MainTopBar
import com.vidovicsystems.gasolinafinder.viewModel.PriceViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: PriceViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            MainTopBar(title = "GasolinaFinder") {}
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }
}


@Composable
fun ContentHomeView(viewModel: PriceViewModel, pad: PaddingValues, navController: NavController) {
    val prices by viewModel.prices.collectAsState()
    LazyColumn(modifier = Modifier.padding(pad)){
        items(prices){ item ->
            GasStationCard(item) {
                navController.navigate("DetailView/${item.IDEESS}")
            }
            
            Text(text = item.Dirección,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}