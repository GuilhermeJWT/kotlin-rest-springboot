package br.com.systemsgs.forumalura.model

import br.com.systemsgs.forumalura.enum.StatusTopico
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ModelTopico (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val  titulo: String,

    val mensagem: String,

    val dataCriacao: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "topico")
    val respostas: List<ModelRespostas> = ArrayList(),

    @ManyToOne
    val curso: ModelCurso,

    @ManyToOne
    val autor: ModelUsuario,

    @Enumerated(EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO

)