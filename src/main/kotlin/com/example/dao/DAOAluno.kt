package com.example.dao

import com.example.model.Aluno

interface DAOAluno {
    suspend fun obterTodos(): List<Aluno>
    suspend fun obter(id: Int): Aluno?
    suspend fun inserir(nome: String, idade: Int): Aluno?
    suspend fun editar(id: Int, nome: String, idade: Int): Boolean
    suspend fun apagar(id: Int): Boolean
}