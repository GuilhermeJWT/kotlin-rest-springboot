package br.com.systemsgs.forumalura.controller

import br.com.systemsgs.forumalura.model.ModelTopico
import br.com.systemsgs.forumalura.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping("/listar")
    fun listar(): List<ModelTopico>{
        return topicoService.listar()
    }

}