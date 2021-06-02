package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelCurso
import br.com.systemsgs.forumalura.model.ModelTopico
import br.com.systemsgs.forumalura.model.ModelUsuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {

    fun listar(): List<ModelTopico>{
        val topico = ModelTopico(id = 1, titulo = "Curso Kotlin", mensagem = "Curso sobre Kotlin e Api",
            curso = ModelCurso(id = 1, nome = "Kotlin", categoria = "Programação Mobile"),
            autor = ModelUsuario(id = 1, nome = "Guilherme Santos", email = "gui@zup.com"),
        )

        return Arrays.asList(topico)
    }

}