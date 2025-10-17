package com.example.tuan3_bai4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan3_bai4.screens.*
import com.example.tuan3_bai4.screens.home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp()
        }
    }
}

@Composable
fun myApp() {
    val navController = rememberNavController() // tạo đối tượng điều hướng trang

    // Container chứa các trang màn hình, bắt đầu từ home
    NavHost(navController, startDestination = "home") {
        composable("home" ) {home(navController)}
        composable("page1") { page1(navController) }
        composable("page2") { page2(navController) }
        composable("page3") { page3(navController) }
        composable("page4") { page4(navController) }
        composable("page5") { page5(navController) }
        composable("page6") { page6(navController) }
        composable("page7") { page7(navController) }
        composable("page8") { page8(navController) }

    }
}
