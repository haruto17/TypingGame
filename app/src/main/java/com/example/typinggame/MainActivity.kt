package com.example.typinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.typinggame.ui.theme.TypingGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypingGameTheme {
                TypingGameApp()
            }
        }
    }
}

@Composable
fun TypingGameApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        HomeScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Home",
            modifier = modifier
        )
        Button(onClick = {}) {
            Text(
                text = "Start"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TypingGameAppPreview() {
    TypingGameTheme {
        TypingGameApp()
    }
}