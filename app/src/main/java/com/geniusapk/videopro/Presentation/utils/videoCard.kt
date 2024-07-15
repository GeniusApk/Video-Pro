package com.geniusapk.videopro.Presentation.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) { }
}