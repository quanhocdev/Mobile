package com.example.tuan1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Description
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Icon
import androidx.compose.foundation.border
import androidx.compose.runtime.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme { // khung theme
        Surface(    // tạo nền
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GreetingScreen("Quan")
        }
    }
}

@Composable
fun GreetingScreen(name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        // Icon góc trên trái với khung xám bo góc
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .border(
                    width = 1.dp,                 // độ dày viền
                    color = Color.Gray,            // màu viền
                    shape = RoundedCornerShape(6.dp) // bo nhẹ góc
                )
                .padding(8.dp) // khoảng cách icon với viền
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }

        // Icon góc trên phải
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .border(
                    width = 1.dp,                 // độ dày viền
                    color = Color.Gray,            // màu viền
                    shape = RoundedCornerShape(6.dp) // bo nhẹ góc
                )
                .padding(8.dp)

        ) {
            Icon(
                imageVector = Icons.Filled.Description,
                contentDescription = "Notebook",
                tint = Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }

        // Nội dung chính ở giữa Box (nếu cần)
    }


    Column( // các phần tử dọc
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // chiếm màn hình cách mép 16
        verticalArrangement = Arrangement.Center,  // can giua
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Image(
            painter = painterResource(id = R.drawable.a1),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)              // kích thước ảnh
                .clip(CircleShape),        // bo góc thành hình tròn
            contentScale = ContentScale.Crop // cắt ảnh cho vừa khung tròn
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Xin chào, $name!", style = MaterialTheme.typography.headlineMedium)

        // khoảng trống giữ chữ và nút
        Spacer(modifier = Modifier.height(16.dp))

        var kick by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Button(onClick = { kick = true }) {
                Text("Bấm vào tôi")
            }

            if (kick) {
                Text("Huỳnh Minh Quân")
                Text("054205002804")
            }
        }

    }
}

// Hàm xem trước
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}
