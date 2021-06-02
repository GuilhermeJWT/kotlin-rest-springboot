package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelCurso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<ModelCurso>) {

    init {
        val curso = ModelCurso(id = 1, nome = "Curso de Kotlin", categoria = "Programação")
        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: Long): ModelCurso{
        return cursos.stream().filter({c -> c.id ==id}).findFirst().get()
    }

}