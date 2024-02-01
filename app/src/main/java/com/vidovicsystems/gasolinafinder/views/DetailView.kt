package com.vidovicsystems.gasolinafinder.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.vidovicsystems.gasolinafinder.viewModel.PriceViewModel

@Composable
fun DetailView(viewModel: PriceViewModel, navController: NavController, id: String){
    Text(text = id.toString())
}