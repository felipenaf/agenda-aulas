package com.example.model

import com.example.utils.DatetimeUtil
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Aluno(
    val id: Int,
    val nome: String,
    val idade: Int,
    val createdAt: Long,
    val updatedAt: Long
)

object Alunos : Table() {
    val id = integer("id").autoIncrement()
    val nome = varchar("nome", 1024)
    val idade = integer("idade")
    val createdAt = long("createdAt").default(DatetimeUtil().currentDatetimeToLong())
    val updatedAt = long("updatedAt").default(DatetimeUtil().currentDatetimeToLong())

    override val primaryKey = PrimaryKey(id)
}