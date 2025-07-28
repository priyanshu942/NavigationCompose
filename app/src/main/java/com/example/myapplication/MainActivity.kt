package com.example.myapplication

import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.descriptors.StructureKind
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var startDestination : Any
    lateinit var viewModel : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
             viewModel = hiltViewModel()
            val flag by  viewModel.flag.collectAsState()
            MyApplicationTheme {
                Log.d("HereIam", "ValueFlag${flag}")

                    startDestination = if (flag) {
                        Log.d("HereIam", "ValueFlag${true}")
                        Screen.ScreenA
                    } else {
                        Log.d("HereIam", "ValueFlag${false}")
                        Screen.ScreenB
                    }

                    IdhaJaa(startDestination)
                }

            Log.d("HereIam","BeforeCallingNavHost")
        }
    }
}

@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier) {
    Log.d("HereIam","Greeting")
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

    }
}

@Composable
fun IdhaJaa(startDestination:Any)
{

    NavHost(navController = rememberNavController(), startDestination = startDestination ) {
        composable<Screen.ScreenA>{
            Log.d("HereIam","InsideGreeting1")
            Greeting1(
                name = "Android",
                modifier = Modifier.padding(50.dp)
            )
        }
        composable<Screen.ScreenB> {
            Log.d("HereIam","InsideGreeting")
            Greeting("Hello World",
                modifier = Modifier.padding(50.dp))
        }
    }
}
