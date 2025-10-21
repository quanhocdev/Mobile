package com.example.tuan4_thuvien.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tuan4_thuvien.viewmodel.LibraryViewModel
import com.example.tuan4_thuvien.viewmodel.StudentRecord

@Composable
fun Home(navController: NavController, libraryViewModel: LibraryViewModel = viewModel()) {
    var input by remember { mutableStateOf("") }
    var searchResult by remember { mutableStateOf<List<String>?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Hệ thống",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, fontSize = 30.sp)
        )
        Text(
            text = "Quản lý thư viện",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Sinh viên",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            TextField(
                value = input,
                onValueChange = { newValue -> input = newValue },
                placeholder = { Text("Nhập tên sinh viên") },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                modifier = Modifier.weight(1f).size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    // Xóa kết quả trước đó
                    searchResult = null
                    errorMessage = null
                    // Kiểm tra input không rỗng
                    if (input.trim().isNotEmpty()) {
                        // Tìm sinh viên trong records
                        val student = libraryViewModel.records.find {
                            it.name.equals(input.trim(), ignoreCase = true)
                        }
                        if (student != null && student.books.isNotEmpty()) {
                            searchResult = student.books
                        } else {
                            errorMessage = "Sinh viên này chưa từng mượn sách"
                        }
                    } else {
                        errorMessage = "Vui lòng nhập tên sinh viên"
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Tìm kiếm")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Danh sách sách",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 5.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.TopStart
        ) {
            when {
                errorMessage != null -> {
                    Text(
                        text = errorMessage!!,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                searchResult != null && searchResult!!.isNotEmpty() -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        items(searchResult!!) { book ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                                    .padding(5.dp)
                                    .background(Color.White),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = "Check",
                                    tint = Color.Green,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = book,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
                else -> {
                    Text(
                        text = "Nhập tên sinh viên để xem sách mượn",
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { navController.navigate("MuonSach") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text("Thêm")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
                Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Blue)
            }
            IconButton(onClick = { navController.navigate("Sach") }) {
                Icon(Icons.Filled.Book, contentDescription = "Sách", tint = Color.Gray)
            }
            IconButton(onClick = { navController.navigate("Svien") }) {
                Icon(Icons.Filled.Person, contentDescription = "Sinh viên", tint = Color.Gray)
            }
        }
    }
}