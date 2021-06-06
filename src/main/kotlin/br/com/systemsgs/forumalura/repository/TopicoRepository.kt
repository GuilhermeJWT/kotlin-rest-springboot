package br.com.systemsgs.forumalura.repository

import br.com.systemsgs.forumalura.model.ModelTopico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository: JpaRepository<ModelTopico, Long> {

}