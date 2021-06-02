package br.com.systemsgs.forumalura.dto

import br.com.systemsgs.forumalura.enum.StatusTopico
import java.time.LocalDateTime

data class TopicoResponseDTO (

    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime

)