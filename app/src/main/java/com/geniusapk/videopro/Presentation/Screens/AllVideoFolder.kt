package com.geniusapk.videopro.Presentation.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.geniusapk.videopro.Presentation.utils.FolderCard


@Composable
fun AllVideoFolder(
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {
    val videoFolders = viewModel.videoFolders.collectAsState().value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(videoFolders.toList()) { (folderName, videos) ->
            FolderCard(
                folderName = folderName,
                videoCount = videos.size,
                navController = navController
            )
        }
    }
}
