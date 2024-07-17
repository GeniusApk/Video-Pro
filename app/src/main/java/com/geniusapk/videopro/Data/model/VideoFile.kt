package com.geniusapk.videopro.Data.model

import android.graphics.Bitmap
import android.net.Uri

data class VideoFile(


    var id: String?,
    var path: String,
    var title: String?,
    var fileNames: String?,
    var size: String?,
    var duration: String?,
    var dateAdded: String?,
    var thumbnailUri: String? = null


)


