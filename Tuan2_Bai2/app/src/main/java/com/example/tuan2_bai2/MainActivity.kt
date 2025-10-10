package com.example.tuan2_bai2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var ten by remember { mutableStateOf("") }
    var tuoi by remember { mutableStateOf("") }
    var ketqua by remember { mutableStateOf("")}
    var numbers by remember { mutableStateOf(listOf<Int>()) }

    var errorMessage by remember { mutableStateOf("") } // 🔹 biến lưu thông báo lỗi
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,             // các phần từ xếp từ trên xuống
        horizontalAlignment = Alignment.CenterHorizontally      // các phần từ căn giữa theo chiều ngang
    ) {
        // 🔹 Phần cố định giữa (tiêu đề + nhập + nút)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {
            Text(
                text = "Thực hành 01",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()            // chiếm toàn chiều ngang (hoặc dùng width cụ thể)
                    .height(150.dp)            // chiều cao box
                    .background(Color.Gray)    // màu nền xám
                    .padding(10.dp)            // khoảng cách bên trong box
            ){
                Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Họ và tên",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    value = ten,    // giá trị của ô
                    onValueChange = {
                        ten = it  // mỗi lần đổi nội dung thì biến input đổi theo
                        errorMessage = ""
                    },  // Xóa lỗi khi người dùng nhập lại
                    modifier = Modifier
                        .width(200.dp),
                    singleLine = true                )

            }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tuổi",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    value = tuoi,    // giá trị của ô
                    onValueChange = {
                        tuoi = it;  // mỗi lần đổi nội dung thì biến input đổi theo
                        errorMessage = ""
                    },  // Xóa lỗi khi người dùng nhập lại
                    modifier = Modifier
                        .width(200.dp),
                    singleLine = true  // không cho phép xuống dòng, hoặc false để xuống dòng

                )

            }
                }
                }
            Button(
                onClick = {
                    val n = tuoi.toIntOrNull()
                    if (n == null || n < 0) {
                        errorMessage = "Tuổi nhập không hợp lệ" // 🔹 báo lỗi
                        ketqua = ""
                    } else if (n < 2) {
                        errorMessage = ""
                        ketqua = "Em bé"
                    } else if (n <= 6) {
                        errorMessage = ""
                        ketqua = "Trẻ em"
                    } else if (n <= 65) {
                        errorMessage = ""
                        ketqua = "Người lớn"
                    } else {
                        errorMessage = ""
                        ketqua = "Người già"
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Kiểm tra")
            }
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 10.dp)
                )
            } else if (ketqua.isNotEmpty()) {
                Text(
                    text = "Kết quả: "+ ten + " là "+ ketqua,
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}