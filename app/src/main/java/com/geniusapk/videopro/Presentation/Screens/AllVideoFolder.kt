package com.geniusapk.videopro.Presentation.Screens

import androidx.compose.foundation.clickable
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


@Composable
fun AllVideoFolder(
    navController: NavController,
    viewModel: MyViewModel = hiltViewModel()
) {

    val videoFolders = viewModel.videoFolders.collectAsState().value

    LazyColumn {
        videoFolders.forEach { (folderName, videos) ->
            item {
                Text(
                    text = folderName,
                    //  style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            // Navigate to a screen showing videos in this folder
                            navController.navigate(Routes.FolderVideosScreen(folderName))
                        }
                )
            }
        }
    }
}