package com.example.tuan2_bai1

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
    var input by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf(listOf<Int>()) }
    var errorMessage by remember { mutableStateOf("") } // 🔹 biến lưu thông báo lỗi
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .padding(top = 230.dp),

        verticalArrangement = Arrangement.Top,                  // các phần từ xếp từ trên xuống
        horizontalAlignment = Alignment.CenterHorizontally      // các phần từ căn giữa theo chiều ngang
    ) {
        // 🔹 Phần cố định giữa (tiêu đề + nhập + nút)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {
            Text(
                text = "Thực hành 02",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Row {
                TextField(
                    value = input,    // giá trị của ô
                    onValueChange = { input = it  // mỗi lần đổi nội dung thì biến input đổi theo
                        errorMessage = "" },  // Xóa lỗi khi người dùng nhập lại
                    placeholder = { Text("Nhập vào số lượng") },
                    modifier = Modifier.weight(1f) // ô nhập chiếm toàn bộ còn lại trong hàng
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        val n = input.toIntOrNull()
                        if (n == null || n <= 0) {
                            errorMessage = "Dữ liệu nhập không hợp lệ" // 🔹 báo lỗi
                            numbers = emptyList()
                        } else {
                            errorMessage = ""
                            numbers = (1..n).toList()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
                ) {
                    Text("Tạo")
                }
            }
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // 🔹 Phần danh sách số (luôn ở dưới, không đẩy phần trên)
        LazyColumn(
            modifier = Modifier
                .weight(1f, fill = false)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),  // mỗi phần tử in ra sẽ cách phần tử kia 12dp theo chiều dọc
            horizontalAlignment = Alignment.CenterHorizontally  //căn giữa toàn bộ theo chiều ngang
        ) {
            items(numbers.size) { index ->   // hàm lamda lấy chỉ số index bắt đầu từ 0 đến numbers.size - 1
                val so = numbers[index] // lấy phần tử tại index
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(
                            color = Color(0xFFE53935),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .height(45.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$so",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}