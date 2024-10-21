package com.assignment.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.assignment.composeexample.ui.theme.ComposeExampleTheme
import com.assignment.composeexample.view.testing.FirstScreen
import com.assignment.composeexample.view.testing.SecondScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ComposeExampleTheme {
                CupcakeApp()
            }
        }
     //   printEvenOdd()

        /*setContent {
            ComposeExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navHostApp()
                }
            }
        }*/
    }

    private fun printEvenOdd() {
        runBlocking {
            var sharedNumber = 1 // Shared variable
            val mutex = Mutex()

            // Coroutine to print even numbers
            val evenJob = launch {
                repeat(10) {  // Adjust the repeat count as per your requirement
                    mutex.withLock {
                        if (sharedNumber % 2 == 0) {
                            println("Concurrency Even: ${sharedNumber++}")
                        }
                    }
                    delay(1000) // Small delay to allow alternate coroutine execution
                }
            }

            // Coroutine to print odd numbers
            val oddJob = launch {
                repeat(10) {
                    mutex.withLock {
                        if (sharedNumber % 2 != 0) {
                            println("Concurrency Odd: ${sharedNumber++}")
                        }
                    }
                    delay(1000) // Small delay to allow alternate coroutine execution
                }
            }

            // Wait for both coroutines to finish
            evenJob.join()
            oddJob.join()
        }
    }

    @Composable
    fun navHostApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "firstScreen") {
            composable(route = "firstScreen") {
                FirstScreen(navController = navController)
            }
            composable(route = "secondScreen/{messageObj}") { navBackStackEntry ->
                val messageObj =
                    navBackStackEntry.arguments?.getString("messageObj", "")
                if (messageObj != null) {
                    SecondScreen(navController = navController, message = messageObj)
                }
            }
        }
    }

}
