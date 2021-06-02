package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.model.ModelTopico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<ModelTopico> = ArrayList(),
    private val cursoService: CursoService,
    private val autorService: UsuarioService) {

    fun listar(): List<TopicoResponseDTO>{
        return topicos.stream().map {t -> TopicoResponseDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoResponseDTO {
       val topico =  topicos.stream().filter({t -> t.id == id}).findFirst().get()

        return TopicoResponseDTO(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )

    }

    fun cadastrar(topicoDTO: ModelTopicoDTO) {
        topicos = topicos.plus(
            ModelTopico(
            id = topicos.size.toLong() +1,
            titulo = topicoDTO.titulo,
            mensagem = topicoDTO.mensagem,
            curso = (cursoService.buscarPorId(topicoDTO.idCurso)),
            autor = (autorService.buscarPorId(topicoDTO.idAutor))
            ))
    }

}