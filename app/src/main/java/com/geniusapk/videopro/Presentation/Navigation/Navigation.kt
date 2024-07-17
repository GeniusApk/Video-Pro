package com.geniusapk.videopro.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.geniusapk.videopro.Presentation.Screens.AllVideoFolder
import com.geniusapk.videopro.Presentation.Screens.App
import com.geniusapk.videopro.Presentation.Screens.ExoPlayerScreen
import com.geniusapk.videopro.Presentation.Screens.FolderVideosScreen
import com.geniusapk.videopro.Presentation.Screens.HomeScreen

@Composable
fun Navigation(

){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.app){
        composable<Routes.app>{
            App(navController = navController)
        }


        composable<Routes.HomeScreen>{
            HomeScreen(navController)
        }
        composable<Routes.PlayerScreen>{
          //  PlayerScreen(navController)
            val videoUri : Routes.PlayerScreen = it.toRoute<Routes.PlayerScreen>()
            ExoPlayerScreen(videoUri.VideoUri , videoUri.title)
        }
        composable<Routes.FolderVideosScreen> {
            val folderName: Routes.FolderVideosScreen = it.toRoute()
            FolderVideosScreen(navController = navController, folderName = folderName.folderName)
        }

        composable<Routes.AllVideoFolder> {
            val folderName: Routes.AllVideoFolder = it.toRoute()
            AllVideoFolder(navController = navController )
        }

    }
}