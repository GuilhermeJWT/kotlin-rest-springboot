package br.com.systemsgs.forumalura.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ModelRespostas (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val mensagem: String,

    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    val solucao: Boolean,

    @ManyToOne
    val autor: ModelUsuario,

    @ManyToOne
    val topico: ModelTopico


)