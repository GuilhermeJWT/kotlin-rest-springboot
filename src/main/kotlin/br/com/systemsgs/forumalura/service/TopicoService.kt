package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.model.ModelTopico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<ModelTopico> = ArrayList(),
    private val cursoService: CursoService,
    private val autorService: UsuarioService) {

    fun listar(): List<ModelTopico>{
        return topicos
    }

    fun buscarPorId(id: Long): ModelTopico {
        return topicos.stream().filter({t -> t.id == id}).findFirst().get()
    }

    fun cadastrar(topicoDTO: ModelTopicoDTO) {
        topicos.plus(
            ModelTopico(
            id = topicos.size.toLong() +1,
            titulo = topicoDTO.titulo,
            mensagem = topicoDTO.mensagem,
            curso = (cursoService.buscarPorId(topicoDTO.idCurso)),
            autor = (autorService.buscarPorId(topicoDTO.idAutor))
            ))
    }

}