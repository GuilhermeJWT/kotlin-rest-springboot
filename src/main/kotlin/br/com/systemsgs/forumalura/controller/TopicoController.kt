package br.com.systemsgs.forumalura.controller

import br.com.systemsgs.forumalura.dto.AtualizaTopicoDTO
import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @PostMapping("/salvar")
    @Transactional
    fun cadastrarTopico(@RequestBody @Valid topicoDTO: ModelTopicoDTO, builder : UriComponentsBuilder): ResponseEntity<TopicoResponseDTO>{
        val topicoCriado = topicoService.cadastrar(topicoDTO)
        val uri = builder.path("/topicos/${topicoCriado.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoCriado)
    }

    @GetMapping("/listar")
    fun listaTodosTopicos(): List<TopicoResponseDTO>{
        return topicoService.listar()
    }

    @GetMapping("/buscar/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoResponseDTO{
        return topicoService.buscarPorId(id)
    }

    @PutMapping("/editar")
    @Transactional
    fun atualizarTopico(@RequestBody @Valid topicoDTO: AtualizaTopicoDTO): ResponseEntity<TopicoResponseDTO>{
        val topicoAtualizado = topicoService.atualizar(topicoDTO)
        return ResponseEntity.ok(topicoAtualizado)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun removeTopico(@PathVariable id: Long){
        topicoService.deletar(id)
    }

}