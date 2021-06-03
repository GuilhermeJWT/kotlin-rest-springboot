package br.com.systemsgs.forumalura.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ModelTopicoDTO (

    @field:NotBlank(message = "O Titulo deve ser Informado!")
    val titulo: String,

    @field:NotBlank(message = "A Mensagem deve ser Informado!")
    val mensagem: String,

    @field:NotNull(message = "O ID do Curso não pode ser Vázio!")
    val idCurso: Long,

    @field:NotNull(message = "O ID do Autor não pode ser Vázio!")
    val idAutor: Long

)