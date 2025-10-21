
package com.example.bt

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun page1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start // căn trái toàn bộ nội dung
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "UI Components List",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color(0xFF2196F3), // xanh dương
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ButtonBox("Text", "Displays text") { navController.navigate("page2") }
        ButtonBox("Image", "Displays an image") { navController.navigate("page3") }

        ButtonBox("TextField", "Input field for text") { navController.navigate("page4") }
        ButtonBox("PasswordField", "Input field for passwords") { navController.navigate("page7") }

        ButtonBox("Column", "Arranges elements vertically") { navController.navigate("page6") }
        ButtonBox("Row", "Arranges elements horizontally") { navController.navigate("page5") }
        ButtonBox("Box", "Arranges elements overlap") { navController.navigate("page8") }

    }
}

// 🔸 Hàm tái sử dụng cho mỗi box xanh nhạt
@Composable
fun ButtonBox(title: String, subtitle: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBDEFB))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(title, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color.Black, fontSize = 12.sp)
        }
    }
}
