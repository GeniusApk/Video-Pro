package com.geniusapk.videopro.Presentation.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.geniusapk.videopro.Presentation.Navigation.Routes
import com.geniusapk.videopro.Presentation.ViewModels.MyViewModel
import com.geniusapk.videopro.Presentation.utils.videoCard

@Composable
fun AllVideoScreen(
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        val allVideos = viewModel.VideoList.collectAsState().value
        Log.d("AllVideoScreen", "AllVideoScreen: ${allVideos}")
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(allVideos) {
                videoCard(
                    path = it.path,
                    title = it.title ?: "Untitled",
                    size = it.size ?: "Unknown",
                    duration = it.duration ?: "Unknown",
                    dateAdded = it.dateAdded ?: "Unknown",
                    fileNames = it.fileNames ?: "Unknown",
                    thumbnail = it.thumbnailUri ?: "Unknown",
                    id = it.id ?: "Unknown",
                    navController = navController,

                )
            }
        }


    }
}
