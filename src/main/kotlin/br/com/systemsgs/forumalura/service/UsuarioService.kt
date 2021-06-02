package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.model.ModelCurso
import br.com.systemsgs.forumalura.model.ModelUsuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var usuarios: List<ModelUsuario>) {

    init {
        val usuario = ModelUsuario(id = 1, nome = "Guilherme Santos", email = "gui@zup.com")
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): ModelUsuario {
        return usuarios.stream().filter({u -> u.id ==id}).findFirst().get()
    }

}