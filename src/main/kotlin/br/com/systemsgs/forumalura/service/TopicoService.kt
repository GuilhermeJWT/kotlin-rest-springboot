package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.dto.AtualizaTopicoDTO
import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.exception.NotFoundException
import br.com.systemsgs.forumalura.mapper.TopicoConverterFormMapper
import br.com.systemsgs.forumalura.mapper.TopicoConverterMapper
import br.com.systemsgs.forumalura.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicosRepository: TopicoRepository,
    private val converterMapper: TopicoConverterMapper,
    private val converterTopicoConverterMapper: TopicoConverterFormMapper,
    private val notFoundMessage: String = "Recurso não Encontrado!") {

    fun listar(): List<TopicoResponseDTO>{
        return topicosRepository.findAll().stream().map {t -> converterMapper.map(t)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoResponseDTO {
       val topico =  topicosRepository.findById(id).orElseThrow {NotFoundException(notFoundMessage)}

        return converterMapper.map(topico)
    }

    fun cadastrar(topicoDTO: ModelTopicoDTO): TopicoResponseDTO {
        val topico = converterTopicoConverterMapper.map(topicoDTO)
        topicosRepository.save(topico)
        return converterMapper.map(topico)
    }

    fun atualizar(topicoDTO: AtualizaTopicoDTO): TopicoResponseDTO {
        val topico =  topicosRepository.findById(topicoDTO.id).orElseThrow {NotFoundException(notFoundMessage)}

        topico.titulo = topicoDTO.titulo
        topico.mensagem = topicoDTO.mensagem

        return converterMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicosRepository.deleteById(id)
    }

}