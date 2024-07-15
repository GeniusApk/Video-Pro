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
                Card(
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.PlayerScreen(it.path))

                    },
                )
                {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Thumbnail
                        AsyncImage(
                            model = it.thumbnailUri,
                            contentDescription = "Video thumbnail",
                            modifier = Modifier
                                .size(64.dp)
                                .padding(end = 16.dp)
                        )

                        // Video details
                        Column {
                            Text(text = it.title ?: "Untitled")
                            Text(text = "Duration: ${it.duration}")
                            Text(text = "Size: ${it.size}")
                            Text(text = "Added: ${it.dateAdded}")
                        }
                    }
                }
            }
        }
    }
}
