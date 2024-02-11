package com.vidovicsystems.gasolinafinder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vidovicsystems.gasolinafinder.viewModel.GasStationViewModel
import com.vidovicsystems.gasolinafinder.viewModel.LoginViewModel
import com.vidovicsystems.gasolinafinder.views.app.DetailView
import com.vidovicsystems.gasolinafinder.views.app.HomeView
import com.vidovicsystems.gasolinafinder.views.login.TabsView

@Composable
fun NavManager(loginViewModel: LoginViewModel, gasStationViewModel: GasStationViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){
            TabsView(navController, loginViewModel)
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