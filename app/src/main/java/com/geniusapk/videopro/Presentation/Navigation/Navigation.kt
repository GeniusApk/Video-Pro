package com.geniusapk.videopro.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.geniusapk.videopro.Presentation.Screens.HomeScreen

@Composable
fun Navigation(

){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{
            HomeScreen(navController)
        }
        composable<Routes.PlayerScreen>{
          //  PlayerScreen(navController)
        }

    }
}