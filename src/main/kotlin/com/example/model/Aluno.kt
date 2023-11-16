package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Aluno(val id: Int, val nome: String, val idade: Int)
object Alunos : Table() {
    val id = integer("id").autoIncrement()
    val nome = varchar("nome", 1024)
    val idade = integer("idade")

    override val primaryKey = PrimaryKey(id)
}