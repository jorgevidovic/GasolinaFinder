package com.vidovicsystems.gasolinafinder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vidovicsystems.gasolinafinder.viewModel.PriceViewModel
import com.vidovicsystems.gasolinafinder.views.DetailView
import com.vidovicsystems.gasolinafinder.views.HomeView

@Composable
fun NavManager(viewModel: PriceViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("DetailView/{IDEESS}", arguments = listOf(
            navArgument("IDEESS"){
                type = NavType.StringType
            }
        )){
            val id = it.arguments?.getString("IDEESS") ?: 0
            DetailView(viewModel, navController, id.toString())
        }
    }
}