package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelCurso
import br.com.systemsgs.forumalura.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private var cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): ModelCurso{
        return cursoRepository.getOne(id)
    }

}