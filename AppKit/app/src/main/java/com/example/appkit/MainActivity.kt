package com.example.appkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appkit.ui.theme.AppKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            CustomToolbar(title = "Libreria Composables")
                        },
                        content = {
                            Column(modifier = Modifier
                                .padding(paddingValues = it)
                                .fillMaxSize()) {

                                Loading(modifier = Modifier
                                    .height(120.dp)
                                    .width(120.dp))

                                ErrorCard(message = "Este es un error", modifier = Modifier.fillMaxWidth())
                            }
                        }
                    )
                }
            }
        }
    }
}