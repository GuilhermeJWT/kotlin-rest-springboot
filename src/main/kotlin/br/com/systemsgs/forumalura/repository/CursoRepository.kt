package br.com.systemsgs.forumalura.repository

import br.com.systemsgs.forumalura.model.ModelCurso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository<ModelCurso, Long> {

}