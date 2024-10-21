package com.assignment.composeexample.view.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {

    var firstName by remember {
        mutableStateOf("")
    }
    var secondName by remember {
        mutableStateOf("")
    }

    val msg = navController.currentBackStackEntry?.savedStateHandle?.get<String>("msg")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = firstName, onValueChange = {
            firstName = it
        }, placeholder = {
            Text(text = "Enter First Name")
        })

        Spacer(modifier = Modifier.height(5.dp))

        TextField(value = secondName, onValueChange = {
            secondName = it
        }, placeholder = {
            Text(text = "Enter second Name")
        })
        val data = Profile("e", "r")

        
        Button(onClick = {
            navController.navigate("secondScreen/${firstName + secondName}")
        }) {
            Text(text = "Navigate To Second Screen")
        }

        msg.let {
            if (msg != null) {
                Text(text = msg)
            }
        }
    }
}

@Composable
fun ComposableLifecycle(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onEvent: (LifecycleOwner, Lifecycle.Event) -> Unit
) {
    val observer = LifecycleEventObserver{source,event->
        onEvent(source,event)
    }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { source, event ->
            onEvent(source, event)
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}