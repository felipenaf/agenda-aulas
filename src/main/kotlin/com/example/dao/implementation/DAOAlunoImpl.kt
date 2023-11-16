package com.example.dao.implementation

import com.example.dao.DAOAluno
import com.example.dao.database.DatabaseFactory.dbQuery
import com.example.model.Aluno
import com.example.model.Alunos
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager

class DAOAlunoImpl: DAOAluno {
    private fun resultRowToObject(row: ResultRow) = Aluno(
        id = row[Alunos.id],
        nome = row[Alunos.nome],
        idade = row[Alunos.idade],
    )
    override suspend fun obterTodos(): List<Aluno> = dbQuery {
        Alunos.selectAll().map(::resultRowToObject)
    }

    override suspend fun obter(id: Int): Aluno? {
        TODO("Not yet implemented")
    }

    override suspend fun inserir(nome: String, idade: Int): Aluno? = dbQuery {
        val insertStatement = Alunos.insert {
            it[Alunos.nome] = nome
            it[Alunos.idade] = idade
        }

        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToObject)
    }

    override suspend fun editar(id: Int, nome: String, idade: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun apagar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    suspend fun truncate(): Int = dbQuery {
        val conn = TransactionManager.current().connection
        val statement = conn.prepareStatement("truncate table Alunos", false)
        statement.executeUpdate()
    }
}
