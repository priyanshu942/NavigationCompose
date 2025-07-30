package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.lifecycle.viewmodel.compose.viewModel
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            MyApplicationTheme {
                First()
                }

        }
    }
}

@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier, viewModel: MyViewModel) {
    Log.d("HereIam","Greeting")
    Log.d("HereIamGreeting1","ScreenA ${viewModel}")


    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

//        Button(onClick = {
//            viewModel.change()
//        }) {
//            Text("Click me to next")
//        }


    }
}

@Composable
fun First( viewModel: MyViewModel = hiltViewModel())
{
    Log.d("HereIam","InsideFirst")
    Text("HereIamFirst")
    val see by viewModel.flag.collectAsState()
    val startDestination = if(see)
    {
        Screen.ScreenA
    }
    else{
        Screen.ScreenB
    }
    IdhaJaa(startDestination, viewModel)
}

@Composable
fun IdhaJaa(startDestination:Any, viewModel: MyViewModel)
{
    NavHost(navController = rememberNavController(), startDestination = startDestination ) {
        composable<Screen.ScreenA>{
            Log.d("HereIam","InsideGreeting1")
            Greeting1(
                name = "Android",
                modifier = Modifier.padding(50.dp),
                viewModel = viewModel
                )
        }
        composable<Screen.ScreenB> {
            Log.d("HereIam","InsideGreeting")
            Greeting("Hello World",
                modifier = Modifier.padding(50.dp),
                vm=viewModel
            )
        }
    }
}
