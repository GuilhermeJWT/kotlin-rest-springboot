package br.com.systemsgs.forumalura.service

import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.mapper.TopicoConverterFormMapper
import br.com.systemsgs.forumalura.mapper.TopicoConverterMapper
import br.com.systemsgs.forumalura.model.ModelTopico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<ModelTopico> = ArrayList(),
    private val converterMapper: TopicoConverterMapper,
    private val converterTopicoConverterMapper: TopicoConverterFormMapper) {

    fun listar(): List<TopicoResponseDTO>{
        return topicos.stream().map {t -> converterMapper.map(t)}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoResponseDTO {
       val topico =  topicos.stream().filter({t -> t.id == id}).findFirst().get()

        return converterMapper.map(topico)
    }

    fun cadastrar(topicoDTO: ModelTopicoDTO) {
        val topico = converterTopicoConverterMapper.map(topicoDTO)
        topico.id = topicos.size.toLong() +1
        topicos = topicos.plus(topico)
    }

}