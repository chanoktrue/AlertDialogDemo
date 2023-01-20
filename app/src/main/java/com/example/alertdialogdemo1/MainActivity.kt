package com.example.alertdialogdemo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alertdialogdemo1.ui.theme.AlertDialogDemo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxSize().background(Color.Green),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DialogUI()
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DialogUI() {

    val shouldShowDialog = remember { mutableStateOf(false) }

    Button(onClick = { shouldShowDialog.value = true }) {
        Text(text = "Show Alert ")
    }
    
    if (shouldShowDialog.value) {
       AlertDialog(
           onDismissRequest = { shouldShowDialog.value = false },
           title = { Text(text = "Dialog")},
           text = { Text(text = "This is jetpack dialog")},
           confirmButton = {
               Button(
                   onClick = { shouldShowDialog.value = false },
                   colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
               ) {
                    Text(text = "Close", color = Color.White)
               }
           }
       )
    }
}


