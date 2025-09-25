package com.example.countrypicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.countrypicker.ui.screens.PhonePickerScreen
import com.example.countrypicker.ui.theme.CountryPickerTheme
import com.example.countrypicker.ui.theme.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val window = rememberWindowSizeClass()
            CountryPickerTheme(windowSizeClass = window) {
                PhonePickerScreen()
            }
        }
    }
}
