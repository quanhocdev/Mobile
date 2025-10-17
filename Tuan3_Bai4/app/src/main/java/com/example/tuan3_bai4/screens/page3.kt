package com.example.tuan3_bai4.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tuan3_bai4.R

@Composable
fun page3(navController: NavController) {
    val uriHandler = LocalUriHandler.current
    val ratio = 1280f / 847f
    // Đặt Text trong Box hoặc Column để hiển thị
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                text = "Images",
                modifier = Modifier.fillMaxWidth().padding(7.dp), // chỉ căn ngang
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Blue
            )
        }

        Spacer(modifier = Modifier.height(16.dp))  // Khoảng cách sau header
            val imageUrl = "https://minhtuanmobile.com/uploads/blog/diem-chuan-dh-giao-thong-van-tai-tp-ho-chi-minh-uth-2025-250620032744.webp"  // Thay bằng URL ảnh thực từ web
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio)
                    .clip(RoundedCornerShape(60.dp))

            )


        Text(
            text = "https://minhtuanmobile.com/uploads/blog/diem-chuan-dh-giao-thong-van-tai-tp-ho-chi-minh-uth-2025-250620032744.webp",
            color = Color.Blue,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                uriHandler.openUri("https://minhtuanmobile.com/uploads/blog/diem-chuan-dh-giao-thong-van-tai-tp-ho-chi-minh-uth-2025-250620032744.webp")
            }
        )
        Image(
            painter = painterResource(id = R.drawable.a2),  // Thay bằng tên file thực của bạn
            contentDescription = "Ảnh điểm chuẩn trường ĐH",  // Accessibility
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio)   // Giữ ratio nếu cần, hoặc xóa nếu ảnh tự scale
                .clip(RoundedCornerShape(60.dp))
        )
        Text(
            text = "In app",
            modifier = Modifier.fillMaxWidth(), // chỉ căn ngang
            textAlign = TextAlign.Center,
        )
    }
}
