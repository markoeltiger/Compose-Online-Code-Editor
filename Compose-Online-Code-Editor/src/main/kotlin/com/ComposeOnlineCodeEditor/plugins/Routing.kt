package com.ComposeOnlineCodeEditor.plugins

import com.ComposeOnlineCodeEditor.compose.ComposeManager
import io.ktor.http.*
import org.jetbrains.compose.web.renderComposable
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/tocompose") {
            val composeManager:ComposeManager=ComposeManager()
            val html = renderComposable(requireNotNull(call.request.queryParameters["name"])) {
                composeManager.Greeting()
            }.toHtml()

            call.respondText(html, ContentType.Text.Html)
        }
        }
    }


