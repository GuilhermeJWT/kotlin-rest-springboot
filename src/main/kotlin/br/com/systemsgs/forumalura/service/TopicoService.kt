package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelCurso
import br.com.systemsgs.forumalura.model.ModelTopico
import br.com.systemsgs.forumalura.model.ModelUsuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<ModelTopico>) {

    init {
        val topico = ModelTopico(id = 1, titulo = "Curso Kotlin", mensagem = "Curso sobre Kotlin e Api",
            curso = ModelCurso(id = 1, nome = "Kotlin", categoria = "Programação Mobile"),
            autor = ModelUsuario(id = 1, nome = "Guilherme Santos", email = "gui@zup.com"),
        )

        topicos =  Arrays.asList(topico)
    }

    fun listar(): List<ModelTopico>{
        return topicos
    }

    fun buscarPorId(id: Long): ModelTopico {
        return topicos.stream().filter({t -> t.id == id}).findFirst().get()
    }

}