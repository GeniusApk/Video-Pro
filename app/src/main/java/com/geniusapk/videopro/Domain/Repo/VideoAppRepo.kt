package com.geniusapk.videopro.Domain.Repo

import android.app.Application
import com.geniusapk.videopro.Data.model.VideoFile
import kotlinx.coroutines.flow.Flow

interface VideoAppRepo {

   suspend fun getAllVideos(application: Application): Flow<ArrayList<VideoFile>>
   //te
   suspend fun getVideosByFolder(application: Application): Flow<Map<String, List<VideoFile>>>


}