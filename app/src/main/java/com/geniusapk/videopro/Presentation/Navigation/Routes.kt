package com.geniusapk.videopro.Presentation.Navigation

import kotlinx.serialization.Serializable

sealed  class Routes {
    @Serializable
    object HomeScreen

    @Serializable
    data class  PlayerScreen(val VideoUri: Int)

}

