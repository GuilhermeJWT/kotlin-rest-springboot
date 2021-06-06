package br.com.systemsgs.forumalura.repository

import br.com.systemsgs.forumalura.model.ModelUsuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<ModelUsuario, Long> {

}