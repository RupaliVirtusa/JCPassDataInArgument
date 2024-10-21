package com.assignment.composeexample.view.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, message: String) {

    var myText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = message)

        TextField(value = myText, onValueChange = {
            myText = it
        }, placeholder = {
            Text(text = "Enter Some Text here", color = Color.Gray)
        })
        Button(onClick = {
            navController.previousBackStackEntry?.savedStateHandle?.set(
                "msg",
                myText
            )
            navController.popBackStack()
        }) {
            Text(text = "Go Back")
        }

    }

}