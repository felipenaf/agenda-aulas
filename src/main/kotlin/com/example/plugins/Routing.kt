package com.example.plugins

import com.example.dao.implementation.DAOAlunoImpl
import com.example.model.Aluno
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/aluno") {
            val ahh: List<Aluno> = DAOAlunoImpl().obterTodos()
            call.respond(ahh)
        }

        post("/aluno") {
            val ahh: Aluno? = DAOAlunoImpl().inserir("Felipe", 31)

            if (ahh == null) {
                call.respond(
                    HttpStatusCode.InternalServerError,
                    "Falha no insert"
                )
            }

            call.respond(ahh?: "")
        }

        get("/truncate") {
            DAOAlunoImpl().truncate()
        }
    }
}
