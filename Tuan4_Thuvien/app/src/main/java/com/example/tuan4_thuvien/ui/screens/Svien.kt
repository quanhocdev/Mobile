package com.example.tuan4_thuvien.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.navigation.currentBackStackEntryAsState
import com.example.tuan4_thuvien.viewmodel.LibraryViewModel

@Composable
fun Svien(navController: NavController, viewModel: LibraryViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        // Tiêu đề
        Text(
            text = "Danh sách mượn sách",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Danh sách sinh viên (dạng box/lazy)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(viewModel.records) { record ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Tên sinh viên: ${record.name}",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF1976D2)
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("Sách đã mượn:", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        record.books.forEach { book ->
                            Text("• $book")
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // ✅ Thanh icon điều hướng dưới cùng (giống bản gốc của bạn)
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = if (currentRoute == "Home") Color.Blue else Color.Gray
                )
            }
            IconButton(onClick = { navController.navigate("Sach") }) {
                Icon(
                    Icons.Filled.Book,
                    contentDescription = "Sách",
                    tint = if (currentRoute == "Sach") Color.Blue else Color.Gray
                )
            }
            IconButton(onClick = { navController.navigate("Svien") }) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Sinh viên",
                    tint = if (currentRoute == "Svien") Color.Blue else Color.Gray
                )
            }
        }

    }
}
