package com.geniusapk.videopro.Data.RepoImpl

import android.app.Application
import android.content.ContentUris
import android.media.ThumbnailUtils
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import com.geniusapk.videopro.Data.model.VideoFile
import com.geniusapk.videopro.Domain.Repo.VideoAppRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import java.io.File

class VideoAppRepoImpl : VideoAppRepo {
//   override fun getAllVideos(application: Application): ArrayList<VideoFile> {
//
//    }

    override suspend fun getAllVideos(application: Application): Flow<ArrayList<VideoFile>> {
        val allVIdeo = ArrayList<VideoFile>()

        val projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.DATE_ADDED,
            MediaStore.Video.Media.DURATION,
            MediaStore.Video.Media.DISPLAY_NAME,

        )
        val Uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI

        val memoryCursor = application.contentResolver.query(Uri, projection, null, null, null)
        if (memoryCursor != null) {
            while (memoryCursor.moveToNext()) {
                val id = memoryCursor.getString(0)
                val path = memoryCursor.getString(1)
                val title = memoryCursor.getString(2)
                val size = memoryCursor.getString(3)
                val dateAdded = memoryCursor.getString(4)
                val duration = memoryCursor.getString(5)
                val fileNames = memoryCursor.getString(6)

                val contentUri = ContentUris.withAppendedId(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    id.toLong()

                )

                val videoFile = VideoFile(
                    id = id,
                    path = path,
                    title = title,
                    size = size,
                    dateAdded = dateAdded,
                    duration = duration,
                    fileNames = fileNames,
                    thumbnailUri = contentUri.toString()


                )




                allVIdeo.add(videoFile)
                if (memoryCursor.isLast) {
                    break
                }
            }

            memoryCursor.close()




        }
        return flow {
            emit(allVIdeo)
        }

    }
    //test

    override suspend fun getVideosByFolder(application: Application): Flow<Map<String, List<VideoFile>>> {
        val allVideos = getAllVideos(application).first()
        val videosByFolder = allVideos.groupBy { File(it.path).parentFile?.name ?: "Unknown" }
        return flow { emit(videosByFolder) }
    }





}