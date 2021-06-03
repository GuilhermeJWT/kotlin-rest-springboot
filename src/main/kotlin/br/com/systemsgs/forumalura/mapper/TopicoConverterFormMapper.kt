package br.com.systemsgs.forumalura.mapper

import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.model.ModelTopico
import br.com.systemsgs.forumalura.service.CursoService
import br.com.systemsgs.forumalura.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoConverterFormMapper(private val cursoService: CursoService, private val autorService: UsuarioService):Mapper<ModelTopicoDTO, ModelTopico> {

    override fun map(t: ModelTopicoDTO): ModelTopico {
        return ModelTopico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = (cursoService.buscarPorId(t.idCurso)),
            autor = (autorService.buscarPorId(t.idAutor))
        )
    }

}