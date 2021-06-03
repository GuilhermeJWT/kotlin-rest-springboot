package br.com.systemsgs.forumalura.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AtualizaTopicoDTO (

    @field:NotNull
    val id: Long,

    @field:NotBlank(message = "O Titulo deve ser Informado!")
    val titulo: String,

    @field:NotBlank(message = "A Mensagem deve ser Informado!")
    val mensagem: String

)