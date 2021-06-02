package br.com.systemsgs.forumalura.model

import java.time.LocalDateTime

data class ModelRespostas (

    val id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val solucao: Boolean,
    val autor: ModelUsuario,
    val topico: ModelTopico


)