package com.example

import com.example.dao.database.DatabaseFactory
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "192.168.56.103",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
//    todo: debug environment, it doenst work
    println(environment)
    DatabaseFactory.init(environment)
    configureSerialization()
    configureRouting()
}
