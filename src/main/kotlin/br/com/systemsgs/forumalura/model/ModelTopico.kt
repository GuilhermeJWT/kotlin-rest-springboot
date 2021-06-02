package br.com.systemsgs.forumalura.model

import java.time.LocalDateTime

data class ModelTopico (

    val id: Long? = null,
    val  titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    

)