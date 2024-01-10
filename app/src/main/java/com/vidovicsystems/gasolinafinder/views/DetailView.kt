package com.vidovicsystems.gasolinafinder.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.vidovicsystems.gasolinafinder.components.MainButton
import com.vidovicsystems.gasolinafinder.components.MainIconButton
import com.vidovicsystems.gasolinafinder.components.Space
import com.vidovicsystems.gasolinafinder.components.TitleBar
import com.vidovicsystems.gasolinafinder.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "GasolinaFinder") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Yellow
                ), navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController)
    }
}

@Composable
fun ContentDetailView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "GasolinaFinder")
        Space()
        MainButton(name = "Volver", backColor = Color.Yellow, color = Color.Black) {
            navController.popBackStack()
        }
    }
}