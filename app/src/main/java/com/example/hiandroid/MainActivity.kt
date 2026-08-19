package com.example.hiandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiandroid.ui.theme.HiAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HiAndroidTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiAndroidTheme {
        Greeting("Android")
    }
}

@Composable
fun HomeScreen(onAboutClick: () -> Unit ) {
    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
        Text(text = "首頁")

        Button(onClick = onAboutClick) {
            Text(text = "前往 About")
        }
    }
}

@Composable
fun AboutScreen(onHomeClick: () -> Unit ) {
    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
        Text(text = "About")

        Text (text = "my app")

        Button(onClick = onHomeClick) {
            Text(text = "回首頁")
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable ("home") {
            HomeScreen(onAboutClick = {
                navController.navigate("about")
            })
        }

        composable("about") {
            AboutScreen(onHomeClick = {
                navController.navigate("home")
            })
        }
    }
}
