package br.com.systemsgs.forumalura.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/hello"])
class HelloController {

    @GetMapping
    fun hello(): String{
        return "Testando a Api"
    }

}