package com.vidovicsystems.gasolinafinder.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vidovicsystems.gasolinafinder.components.MainTopBar
import com.vidovicsystems.gasolinafinder.viewModel.PriceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(viewModel: PriceViewModel, navController: NavController, IDEESS: String){
    LaunchedEffect(Unit){
        viewModel.getGasStationById(IDEESS)
    }

    Scaffold(
        topBar = {
            MainTopBar(title = IDEESS, showBackButton = true) {
                navController.popBackStack()
            }
        }

    ) {
        ContentDetailView(it, viewModel)
    }
}

@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: PriceViewModel){
    val state = viewModel.state

    Column (modifier = Modifier
        .padding(pad)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 5.dp)
        ){

        }
    }
}