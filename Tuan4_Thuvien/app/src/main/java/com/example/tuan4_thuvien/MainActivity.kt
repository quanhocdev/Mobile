package com.example.tuan4_thuvien

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan4_thuvien.ui.screens.Home
import com.example.tuan4_thuvien.ui.screens.MuonSach
import com.example.tuan4_thuvien.ui.screens.Sach
import com.example.tuan4_thuvien.ui.screens.Svien
import com.example.tuan4_thuvien.viewmodel.LibraryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val libraryViewModel: LibraryViewModel = viewModel() // viewModel compose

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController, libraryViewModel) }
        composable("Sach") { Sach(navController) }
        composable("MuonSach") { MuonSach(navController, libraryViewModel) }
        composable("Svien") { Svien(navController, libraryViewModel) }
    }
}