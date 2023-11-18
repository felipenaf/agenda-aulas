package com.example.plugins

import com.example.dao.implementation.DAOAlunoImpl
import com.example.model.Aluno
import com.example.utils.DatetimeUtil
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.text.SimpleDateFormat

fun Application.configureRouting() {
    routing {
        get("/") {
            println()
            println()
            println(DatetimeUtil(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).longToDate(1700256))
            println(DatetimeUtil(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).dateToLong("1970-01-20 13:17:36.000"))
            println(DatetimeUtil().longToDate(DatetimeUtil().dateToLong("1970-01-20 13:17:36")))
            println()
            println()
            println(DatetimeUtil().dateToLong("2020-12-01 00:00:01"))
            println(DatetimeUtil().currentDatetimeToLong())
            println(DatetimeUtil().currentDatetimeToString())
            println()
            println()
            call.respondText(DatetimeUtil().currentDatetimeToString())
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
    }
}
