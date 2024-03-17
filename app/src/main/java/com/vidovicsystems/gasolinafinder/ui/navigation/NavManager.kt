package com.vidovicsystems.gasolinafinder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vidovicsystems.gasolinafinder.ui.viewModel.GasStationViewModel
import com.vidovicsystems.gasolinafinder.ui.views.app.DetailView
import com.vidovicsystems.gasolinafinder.ui.views.app.HomeView
import com.vidovicsystems.gasolinafinder.ui.views.login.TabsView

@Composable
fun NavManager(gasStationViewModel: GasStationViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){
            TabsView(navController)
        }

        composable("Home"){
            HomeView(gasStationViewModel, navController)
        }
        composable("DetailView/{IDEESS}", arguments = listOf(
            navArgument("IDEESS"){
                type = NavType.StringType
            }
        )){
            val id = it.arguments?.getString("IDEESS") ?: 0
            DetailView(gasStationViewModel, navController, id.toString())
        }
    }
}