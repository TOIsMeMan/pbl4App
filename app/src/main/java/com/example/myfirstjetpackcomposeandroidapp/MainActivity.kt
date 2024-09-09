package com.example.myfirstjetpackcomposeandroidapp

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstjetpackcomposeandroidapp.ui.theme.MyFirstJetpackComposeAndroidAppTheme
import kotlin.reflect.KProperty
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstJetpackComposeAndroidAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 50.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var lightIsOn by remember { mutableStateOf(false) }
                        var textOfLightButton by remember { mutableStateOf("Bat den") }
                        Button(
                            onClick = {
                                lightIsOn = !lightIsOn
                                textOfLightButton = if (lightIsOn) "Tat den" else "Bat den"
                                      },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (lightIsOn) Color.Green else Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "${textOfLightButton}",
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        }
                        var fanIsOn by remember { mutableStateOf(false) }
                        var textOfFanButton by remember { mutableStateOf("Bat quat") }
                        Button(
                            onClick = {
                                fanIsOn = !fanIsOn
                                textOfFanButton = if (fanIsOn) "Tat quat" else "Bat quat"
                                      },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (fanIsOn) Color.Green else Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "${textOfFanButton}",
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        }
                        var doorIsOpen by remember { mutableStateOf(false) }
                        var textOfDoorButton by remember { mutableStateOf("Mo cua") }
                        Button(
                            onClick = {
                                doorIsOpen = !doorIsOpen
                                textOfDoorButton = if (doorIsOpen) "Dong cua" else "Mo cua"
                                      },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (doorIsOpen) Color.Green else Color.Gray
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
                        var micIsOn by remember { mutableStateOf(false) }
                        var textOfMicButton by remember { mutableStateOf("Mic") }
                        Button(
                            onClick = {
                                micIsOn = !micIsOn
                                textOfMicButton = if (micIsOn) "Noi Gi Di" else "Mic"
                                      },
                            modifier = Modifier
                                .width(90.dp)
                                .height(90.dp)
                                .align(Alignment.End),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (micIsOn) Color.Green else Color.Gray
                            ),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "${textOfMicButton}",
                                color = Color.White,
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
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