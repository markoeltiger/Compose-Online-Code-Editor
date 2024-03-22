package com.example.plugins

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
class compose{
    fun convert(){}
    fun composeToHtml(){

        val html = renderComposable("") {
            Greeting()
        }

    }
    @Composable
    fun Greeting(name: String = "fWorld") {
        Text(
      "First Screen",
    )
    }

}