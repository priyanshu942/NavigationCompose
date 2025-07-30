package com.example.myapplication

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(): ViewModel() {
    // Backing property (mutable)
     val _flag = MutableStateFlow(false)

    // Exposed as read-only
    val flag: StateFlow<Boolean> = _flag.asStateFlow()
    fun change()
    {
        _flag.value = true
    }
        }