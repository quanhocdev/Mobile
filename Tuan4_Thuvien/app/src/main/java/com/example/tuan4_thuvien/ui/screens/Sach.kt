package com.example.tuan4_thuvien.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tuan4_thuvien.R

@Composable
fun Sach(navController: NavController) {
    // Danh sách ảnh từ drawable
    val bookImages = listOf(
        R.drawable.book1,
        R.drawable.book2,
        R.drawable.book3,
        R.drawable.book4,
        R.drawable.book5
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        // Tiêu đề
        Text(
            text = "Thư viện Sách",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Box trên: LazyRow ảnh sách nổi bật
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(bookImages) { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Ảnh sách",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(140.dp)
                            .height(180.dp)
                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Box dưới: LazyColumn danh sách 100 sách
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items((1..100).toList()) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text("Sách ${index.toString().padStart(2, '0')}")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Thanh icon điều hướng dưới cùng
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
                Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Gray)
            }
            IconButton(onClick = { navController.navigate("Sach") }) {
                Icon(Icons.Filled.Book, contentDescription = "Sách", tint = Color.Blue)
            }
            IconButton(onClick = { navController.navigate("Svien") }) {
                Icon(Icons.Filled.Person, contentDescription = "Sinh viên", tint = Color.Gray)
            }
        }
    }
}
