package com.example.myfirstjetpackcomposeandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstjetpackcomposeandroidapp.ui.theme.MyFirstJetpackComposeAndroidAppTheme
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    private val ESP8266_URL = "http://10.10.27.246"
    private val TAG: String = "HTTP_Response"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstJetpackComposeAndroidAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(red = 4, green = 41, blue = 64),
                                    Color(red = 0, green = 92, blue = 83)
                                )
                            )
                        )
                ) {
                    Surface (
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Transparent
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 50.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            var lightIsOn by remember { mutableStateOf(false) }
                            var textOfLightButton by remember { mutableStateOf("Bật đèn") }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .background(
                                        if (lightIsOn) Color(red = 255, green = 255, blue = 200)
                                        else Color(red = 200, green = 200, blue = 255)
                                    )
                            ) {
                                Button(
                                    onClick = {
                                        lightIsOn = !lightIsOn
                                        textOfLightButton = if (lightIsOn) "Tắt đèn" else "Bật đèn"
                                        if (lightIsOn) {
                                            sendRequest("/light/on")
                                        } else {
                                            sendRequest("/light/off")
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(
//                                        containerColor = if (lightIsOn) Color(red = 43, green = 140, blue = 68) else Color(red = 143, green = 193, blue = 181)
                                        containerColor = Color.Transparent
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    shape = RoundedCornerShape(30.dp)
                                ) {
                                    Text(
                                        text = "${textOfLightButton}",
                                        color = Color.White,
                                        fontSize = 30.sp
                                    )
                                }
                            }

                            var fanIsOn by remember { mutableStateOf(false) }
                            var textOfFanButton by remember { mutableStateOf("Bật quạt") }
                            Button(
                                onClick = {
                                    fanIsOn = !fanIsOn
                                    textOfFanButton = if (fanIsOn) "Tắt quạt" else "Bật quạt"
                                    if (fanIsOn) {
                                        sendRequest("/fan/on")
                                    } else {
                                        sendRequest("/fan/off")
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (fanIsOn) Color(red = 43, green = 140, blue = 68) else Color(red = 64, green = 64, blue = 64)
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color(red = 43, green = 140, blue = 68),
                                                Color(red = 0, green = 92, blue = 83)
                                            )
                                        )
                                    ),
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    text = "${textOfFanButton}",
                                    color = Color.White,
                                    fontSize = 30.sp
                                )
                            }
                            var doorIsOpen by remember { mutableStateOf(false) }
                            var textOfDoorButton by remember { mutableStateOf("Mở cửa") }
                            Button(
                                onClick = {
                                    doorIsOpen = !doorIsOpen
                                    textOfDoorButton = if (doorIsOpen) "Đóng cửa" else "Mở cửa"
                                    if (doorIsOpen) {
                                        sendRequest("/door/open")
                                    } else {
                                        sendRequest("/door/close")
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (doorIsOpen) Color(red = 43, green = 140, blue = 68) else Color(red = 64, green = 64, blue = 64)
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f),
                                shape = RoundedCornerShape(30.dp)
                            ) {
                                Text(
                                    text = "${textOfDoorButton}",
                                    color = Color.White,
                                    fontSize = 30.sp
                                )
                            }
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(1f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Text(
                                        text = "Nhà Thông Minh",
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        fontSize = 30.sp
                                    )
                                }

                                var micIsOn by remember { mutableStateOf(false) }
                                var textOfMicButton by remember { mutableStateOf("Mic") }
                                Button(
                                    onClick = {
                                        micIsOn = !micIsOn
                                        textOfMicButton = if (micIsOn) "Nói gì đi" else "Mic"
                                    },
                                    modifier = Modifier
                                        .width(90.dp)
                                        .fillMaxHeight()
                                        .padding(end = 0.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (micIsOn) Color(red = 43, green = 140, blue = 68) else Color(red = 64, green = 64, blue = 64)
                                    ),
                                    shape = RoundedCornerShape(30.dp)
                                ) {
                                    Text(
                                        text = "${textOfMicButton}",
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    // Hàm gửi yêu cầu HTTP GET đến ESP8266
    private fun sendRequest(endpoint: String) {
        Thread {
            try {
                // Tạo URL kết nối đến ESP8266
                val url = URL(ESP8266_URL + endpoint)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                // Kiểm tra mã phản hồi HTTP từ server
                val responseCode = connection.responseCode
                Log.d(TAG, "Response Code: $responseCode")

                if (responseCode == 200) {  // Nếu mã phản hồi là 200 OK
                    val response = connection.inputStream.bufferedReader().use { it.readText() }
                    Log.d(TAG, "Response: $response")
                } else {
                    // Xử lý khi nhận phản hồi lỗi
                    Log.e(TAG, "Error Response Code: $responseCode")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e(TAG, "Exception: ${e.message}")
            }
        }.start()
    }
}

@Composable
fun Hello(name: String, modifier: Modifier = Modifier, color: Color = Color.Black) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = color,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    MyFirstJetpackComposeAndroidAppTheme {
        Hello(
            name = "There",
            color = Color.Magenta
            )
    }
}