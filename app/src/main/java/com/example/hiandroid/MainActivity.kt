package com.example.hiandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
fun HomeScreen(onAboutClick: () -> Unit ) {
    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding().padding(16.dp)) {
        Text(text = "首頁")

        Column (modifier = Modifier.height(200.dp).width(200.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text("A")
            Text("B")
            Text("C")
        }

        Row (modifier = Modifier.height(200.dp).width(200.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text("D")
            Text("E")
            Text("F")
        }

        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text("小明")
            Text("設定")
        }

        var name by remember {
            mutableStateOf("")
        }

        TextField(value = name, onValueChange = { newValue: String -> name = newValue})

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text (text = "登入")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text (text = "註冊")
            }
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
