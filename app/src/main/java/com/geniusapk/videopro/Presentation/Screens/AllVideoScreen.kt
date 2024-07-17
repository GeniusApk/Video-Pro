package com.geniusapk.videopro.Presentation.Screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.geniusapk.videopro.Presentation.utils.VideoCard

@Composable
fun AllVideoScreen(
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    val allVideos = viewModel.VideoList.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(allVideos) { video ->
            VideoCard(
                path = video.path,
                title = video.title ?: "Untitled",
                size = video.size ?: "Unknown",
                duration = video.duration ?: "Unknown",
                dateAdded = video.dateAdded ?: "Unknown",
                fileNames = video.fileNames ?: "Unknown",
                thumbnail = video.thumbnailUri ?: "Unknown",
                id = video.id ?: "Unknown",
                navController = navController

            )
        }
    }
}
