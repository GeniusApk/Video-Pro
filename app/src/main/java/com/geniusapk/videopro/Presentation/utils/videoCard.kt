package com.geniusapk.videopro.Presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.geniusapk.videopro.Presentation.Navigation.Routes

@Composable
fun videoCard(
    path: String,
    title: String,
    size: String,
    duration: String,
    dateAdded: String,
    fileNames: String,
    thumbnail: String,
    id: String,
    navController: NavController
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    navController.navigate(Routes.PlayerScreen(path))
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = thumbnail,
                    contentDescription = "Video thumbnail",
                    modifier = Modifier.size(64.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(text = title ?: "Untitled")
                    Text(text = "Duration: ${duration}")
                    Text(text = "Size: ${size}")
                    Text(text = "Added: ${dateAdded}")
                }
            }
        }
    }
}