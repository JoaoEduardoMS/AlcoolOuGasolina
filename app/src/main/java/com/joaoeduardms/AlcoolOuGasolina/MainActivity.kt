package com.joaoeduardms.AlcoolOuGasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaoeduardms.AlcoolOuGasolina.ui.theme.AlcoolOuGasolinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoolOuGasolinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {

    var valorGasolina by remember { mutableStateOf("") }
    var valorAlcool by remember { mutableStateOf("") }

    Column(
        Modifier
            .background(color = Color(0xFFA3A3A3))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Álcool ou Gasolina?",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        AnimatedVisibility(visible = valorAlcool.isNotBlank() && valorGasolina.isNotBlank()) {
            if(valorAlcool.isNotBlank() && valorGasolina.isNotBlank()) {
                val compensaGasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7
                val alcoolOuGalosina = if (compensaGasolina) {
                    "Gasolina"
                } else {
                    "Alcool"
                }
                val cor = if (compensaGasolina) {
                    Color.Red
                } else {
                    Color.Green
                }
                Text(
                    text = alcoolOuGalosina, style = TextStyle(
                        color = cor, fontSize = 40.sp, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
            TextField(value = valorGasolina, onValueChange = { novoValor ->
                    valorGasolina = novoValor
            },  label = {
                Text(text = "Gasolina")
            })
            TextField(value = valorAlcool, onValueChange = {
                    valorAlcool = it
            }, label = {
               Text(text = "Alcool")
            })
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AlcoolOuGasolinaTheme {
        App()
    }
}