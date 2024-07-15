package com.geniusapk.videopro.Presentation.Screens

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.geniusapk.videopro.Presentation.ViewModels.MyViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun App(
    viewModel: MyViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val mediaPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        rememberPermissionState(permission = Manifest.permission.READ_MEDIA_VIDEO)
    } else {
        rememberPermissionState(permission = Manifest.permission.READ_EXTERNAL_STORAGE)
    }
    val mediaPermissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission() ){
        if (it){
            viewModel.showUi.value = true
        }else
        {
            viewModel.showUi.value = false
        }
    }
    LaunchedEffect(key1 = mediaPermission){
        if (!mediaPermission.status.isGranted){
            mediaPermissionLauncher.launch(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    Manifest.permission.READ_MEDIA_VIDEO
                } else {
                    Manifest.permission.READ_EXTERNAL_STORAGE
                }
            )

        }else{
            viewModel.showUi.value = true

        }



    }

    val state  = viewModel.showUi.collectAsState()
    if (state.value){
        HomeScreen( navController = navController)
    }else{
        Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center){
            Text(text = "Please Grant Permission")

        }
    }
}
