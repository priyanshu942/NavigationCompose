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
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, vm: MyViewModel) {
    Log.d("HereIam Screen B", "$vm")
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
           vm.change()
            Log.d("HereIam","ButtonClick ${vm.flag.value}")
        }) {
            Text("Navigate Back")
        }
    }
}

