package com.vidovicsystems.gasolinafinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.vidovicsystems.gasolinafinder.ui.theme.GasolinaFinderTheme
import com.vidovicsystems.gasolinafinder.viewModel.PriceViewModel
import com.vidovicsystems.gasolinafinder.views.HomeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : PriceViewModel by viewModels()

        setContent {
            GasolinaFinderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView(viewModel)
                }
            }
        }
    }
}