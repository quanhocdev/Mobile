package com.example.tuan4_smarttasks.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tuan4_smarttasks.navigation.Screen
import com.example.tuan4_smarttasks.viewmodel.OnboardingViewModel

@Composable
fun OnboardingScreen(
    navController: NavHostController,
    viewModel: OnboardingViewModel = OnboardingViewModel()
) {
    var pageIndex by remember { mutableStateOf(0) }
    val pages = viewModel.pages

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image
        Image(
            painter = painterResource(id = pages[pageIndex].imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        // Text section
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = pages[pageIndex].title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pages[pageIndex].description,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Navigation buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (pageIndex > 0) {
                // 🔹 Icon quay lại (nền tròn xanh biển)
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFF2196F3), shape = CircleShape)
                        .clickable { pageIndex-- },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                // 🔹 Nút Next hoặc Get Started
                Button(
                    onClick = {
                        if (pageIndex < pages.lastIndex) pageIndex++
                        else navController.navigate(Screen.Main.route)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(if (pageIndex < pages.lastIndex) "Next" else "Get Started")
                }
            } else {
                // Trang đầu tiên — chỉ có nút chiếm full width
                Button(
                    onClick = { pageIndex++ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text("Next")
                }
            }
        }
    }
}
