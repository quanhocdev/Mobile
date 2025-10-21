package com.example.bt
import androidx.compose.foundation.lazy.items
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

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
    val a = List(1_000_000) { i -> "$i đây là phần tử ${i + 1}" }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//        for (i in items) {
//            Text(
//                text = "Dòng $i",
//                modifier = Modifier.padding(4.dp)
//            )
//        }
//    }

    LazyColumn {
        items(a) { index ->
            Text(
                text = index
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}