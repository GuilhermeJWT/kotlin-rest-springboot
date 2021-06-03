package br.com.systemsgs.forumalura.mapper

import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.model.ModelTopico
import org.springframework.stereotype.Component

@Component
class TopicoConverterMapper: Mapper<ModelTopico, TopicoResponseDTO> {

    override fun map(t: ModelTopico): TopicoResponseDTO {
        return TopicoResponseDTO(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}