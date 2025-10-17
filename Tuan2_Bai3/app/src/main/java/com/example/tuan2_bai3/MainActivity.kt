package com.example.tuan2_bai3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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

    var input by remember { mutableStateOf("")}
    var ketqua by remember { mutableStateOf("")}
    var errorMessage by remember { mutableStateOf("") } // 🔹 biến lưu thông báo lỗi
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,             // các phần từ xếp từ trên xuống
        horizontalAlignment = Alignment.CenterHorizontally      // các phần từ căn giữa theo chiều ngang
    ) {
        Text(
            text = "Thực hành 02",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        TextField(
            value = input,    // giá trị của ô
            onValueChange = {
                input = it  // mỗi lần đổi nội dung thì biến input đổi theo
                errorMessage = ""
            },  // Xóa lỗi khi người dùng nhập lại
            shape = RoundedCornerShape(12.dp), // bo góc
            placeholder = { Text("Nhập email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)  // chiếm 80% chiều ngang
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 10.dp)
            )
        } else if (ketqua.isNotEmpty()) {
            Text(
                text = ketqua,
                color = Color.Green,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = {
                val n = input
                if (n.isEmpty()){
                    errorMessage = "Email không hợp lệ" // 🔹 báo lỗi
                    ketqua = ""
                }
                else if (!n.contains("@") || n.count {it == '@'} > 1) {
                    errorMessage = "Email không đúng dạng"
                    ketqua = ""
                }
                else{
                    errorMessage = ""
                    ketqua = "Email hợp lệ"
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Kiểm tra")
        }



    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}