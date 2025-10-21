package com.example.tuan4_thuvien.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuan4_thuvien.viewmodel.LibraryViewModel

@Composable
fun MuonSach(navController: NavController, libraryViewModel: LibraryViewModel) {
    var ten by remember { mutableStateOf("") }
    var selectedBooks by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon ở bên trái
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            // Spacer trước để đẩy Text ra giữa
//            Spacer(modifier = Modifier.weight(1f))

            // Text căn giữa
            Text(
                text = "Thông tin mượn sách",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            )

            // Spacer sau để giữ Text ở giữa
//            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Tên sinh viên:")
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = ten,
                onValueChange = { ten = it },
                placeholder = { Text("Nhập tên") },
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Chọn sách:")
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                items((1..50).toList()) { index ->
                    val bookName = "Sách ${index.toString().padStart(2, '0')}"
                    val isSelected = selectedBooks.contains(bookName)

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                            .background(
                                if (isSelected) Color(0xFF90CAF9) else Color.LightGray,
                                RoundedCornerShape(8.dp)
                            )
                            .clickable {
                                selectedBooks = if (isSelected) {
                                    selectedBooks - bookName
                                } else {
                                    selectedBooks + bookName
                                }
                            }
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(bookName)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (ten.isNotBlank() && selectedBooks.isNotEmpty()) {
                    libraryViewModel.addRecord(ten, selectedBooks)
                    ten = ""
                    selectedBooks = emptyList()
                    navController.navigate("Svien")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text("Xác nhận", color = Color.White)
        }
    }
}
