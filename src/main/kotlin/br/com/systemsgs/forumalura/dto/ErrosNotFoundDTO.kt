package br.com.systemsgs.forumalura.dto

import java.time.LocalDateTime

data class ErrosNotFoundDTO (

    val instante: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val erro: String,
    val mensagem: String?,
    val caminhoPath: String

)