package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelUsuario
import br.com.systemsgs.forumalura.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): ModelUsuario {
        return usuarioRepository.getOne(id)
    }

}