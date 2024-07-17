package com.geniusapk.videopro.Presentation.ViewModels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geniusapk.videopro.Data.model.VideoFile
import com.geniusapk.videopro.Domain.Repo.VideoAppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor( val repo: VideoAppRepo , val application: Application) : ViewModel() {
    val showUi = MutableStateFlow(false)

    val VideoList = MutableStateFlow(emptyList<VideoFile>())
    val isLoading = mutableStateOf(false)
    val videoFolders = MutableStateFlow(emptyMap<String, List<VideoFile>>())

    suspend fun loadAllVideos() {
        isLoading.value = true
        viewModelScope.launch {
             repo.getAllVideos(application).collectLatest {
                VideoList.value = it
            }
            Log.d("MyViewModel", "loadAllVideos: ${VideoList.value}")
        }
        isLoading.value = false
    }

    suspend fun loadVideosByFolder() {
        isLoading.value = true
        viewModelScope.launch {
            repo.getVideosByFolder(application).collectLatest {
                videoFolders.value = it
            }
        }
        isLoading.value = false
    }

    init {
        viewModelScope.launch {
            loadAllVideos()
            loadVideosByFolder()        }


    }

}