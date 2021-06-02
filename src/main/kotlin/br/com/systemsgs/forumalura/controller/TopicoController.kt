package br.com.systemsgs.forumalura.controller

import br.com.systemsgs.forumalura.dto.TopicoResponseDTO
import br.com.systemsgs.forumalura.dto.ModelTopicoDTO
import br.com.systemsgs.forumalura.model.ModelTopico
import br.com.systemsgs.forumalura.service.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping("/listar")
    fun listar(): List<TopicoResponseDTO>{
        return topicoService.listar()
    }

    @GetMapping("/buscar/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoResponseDTO{
        return topicoService.buscarPorId(id)
    }

    @PostMapping("/salvar")
    fun cadastrar(@RequestBody topicoDTO: ModelTopicoDTO){
        topicoService.cadastrar(topicoDTO)
    }

}