package br.com.huppers

import br.com.huppers.database.DatabaseSingleton
import br.com.huppers.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseSingleton.init()
    configureSerialization()
    configureRouting()
}
