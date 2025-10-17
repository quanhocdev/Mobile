package com.example.bt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    var out by remember { mutableStateOf("") }
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
        Text(
            text = "Jetpack Compose is a modern",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(modifier = Modifier.height(70.dp))


        Button(
            onClick = {
                out = "Huynh Minh Quan"
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
        )

        {
            Text("I'm ready")
        }
        if(out.isNotEmpty()){
            Text(text = out)
        }



    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}