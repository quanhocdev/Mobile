package com.example.tuan3_bai4.screens
import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun page2(navController: NavController) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        text = "Text Detail",
                        modifier = Modifier.fillMaxWidth().padding(7.dp), // chỉ căn ngang
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Blue


                    )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                )
                            ) {
                                append("The ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    textDecoration = TextDecoration.LineThrough,
                                )
                            ) {
                                append("quick")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    color = Color(0xFFA52A2A), // màu nâu
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" B")
                            }

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    color = Color(0xFFA52A2A), // màu nâu
                                )
                            ) {
                                append("rown ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                )
                            ) {
                                append("fox ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 5.sp
                                )
                            ) {
                                append("Jumps ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                )
                            ) {
                                append("over ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    textDecoration = TextDecoration.Underline,
                                    fontWeight = FontWeight.Bold,
                                )
                            ) {
                                append("the")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 30.sp,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic,

                                    )
                            ) {
                                append(" lazy ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 40.sp,
                                    )
                            ) {
                                append("dog.")
                            }
                        },
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
}
