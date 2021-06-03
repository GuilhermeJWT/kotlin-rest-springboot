package br.com.systemsgs.forumalura.model

import br.com.systemsgs.forumalura.enum.StatusTopico
import java.time.LocalDateTime

data class ModelTopico (

    var id: Long? = null,
    val  titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val respostas: List<ModelRespostas> = ArrayList(),
    val curso: ModelCurso,
    val autor: ModelUsuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO

)