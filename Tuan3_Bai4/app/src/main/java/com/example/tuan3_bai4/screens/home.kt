package com.example.tuan3_bai4.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tuan3_bai4.R
import androidx.compose.ui.unit.sp

@Composable
fun home(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,             // các phần từ xếp từ trên xuống
        horizontalAlignment = Alignment.CenterHorizontally      // các phần từ căn giữa theo chiều ngang
    ) {
        Image(
            painter = painterResource(id = R.drawable.a),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)              // kích thước ảnh
                .clip(CircleShape),        // bo góc thành hình tròn
            contentScale = ContentScale.Crop // cắt ảnh cho vừa khung tròn
        )
        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "Jetpack Compose",

            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 15.sp
            ),
        )

        Spacer(modifier = Modifier.height(70.dp))


        Button(onClick = { navController.navigate("page1") }, modifier = Modifier
            .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,       // Màu nền nút
            contentColor = Color.White         // Màu chữ trong nút
        )
        ) {
            Text("I'm ready")
        }



    }
}

