package com.geniusapk.videopro.Presentation.Screens

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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.geniusapk.videopro.Presentation.Navigation.Routes
import com.geniusapk.videopro.Presentation.ViewModels.MyViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.geniusapk.videopro.Presentation.utils.CustemTopAppBar
import com.geniusapk.videopro.Presentation.utils.VideoCard


// FolderVideoScreen.kt


// FolderVideosScreen.kt
@Composable
fun FolderVideosScreen(
    navController: NavController,
    folderName: String,
    viewModel: MyViewModel = hiltViewModel()
) {


    Scaffold(
        topBar = { CustemTopAppBar(topAppBarText = folderName, navController = navController) }
    ) {innerPadding ->


        val videoFolders = viewModel.videoFolders.collectAsState().value
        val videosInFolder = videoFolders[folderName] ?: emptyList()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videosInFolder) { video ->
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


}
