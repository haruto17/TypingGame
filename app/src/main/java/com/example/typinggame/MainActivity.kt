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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.typinggame.ui.theme.TypingGameTheme

enum class Screen { Home, Game }

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
fun TypingGameApp(
    startDestination: Screen = Screen.Home,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.name) {
                HomeScreen(onStart = { navController.navigate(Screen.Game.name) })
            }
            composable(Screen.Game.name) {
                GameScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(onStart: () -> Unit, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Home",
            modifier = modifier
        )
        Button(onClick = { onStart() }) {
            Text(
                text = "Start"
            )
        }
    }
}

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Game",
        modifier = modifier
    )
}

@Preview(name = "Home", showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    TypingGameTheme { TypingGameApp(startDestination = Screen.Home) }
}

@Preview(name = "Game", showBackground = true, showSystemUi = true)
@Composable
fun GamePreview() {
    TypingGameTheme { TypingGameApp(startDestination = Screen.Game) }
}