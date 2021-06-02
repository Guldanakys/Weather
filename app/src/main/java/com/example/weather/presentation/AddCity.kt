package com.example.weather.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weather.data.DataStore
import com.example.weather.ui.theme.Purple500

@Composable
fun AddCity(navController: NavController, mainViewModel: MainViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Добавление города") },
            backgroundColor = Purple500
        )
    }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            val errorState = remember { mutableStateOf("") }
            Text(
                text = "Новый город",
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    )
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = textState.value,
                onValueChange = { textState.value = it }
            )
            Text(
                text = errorState.value,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                color = Color.Red
            )
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                    if (DataStore.getDefaultCities()
                            .any {
                                it.equals(textState.value.text, ignoreCase = true)
                            }
                    ) {
                        errorState.value = ""
                        DataStore.addCity(textState.value.text)
                        navController.navigate("cityWeatherList") {
                            popUpTo("cityWeatherList") { inclusive = true }
                        }
                        mainViewModel.initCities()
                    } else {
                        errorState.value = "Неверное название"
                    }
                }
            ) {
                Text("ДОБАВИТЬ")
            }
        }
    }
}