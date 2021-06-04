package br.com.systemsgs.forumalura.exception

import br.com.systemsgs.forumalura.dto.ErrosNotFoundDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ApiErrosExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException, request: HttpServletRequest): ErrosNotFoundDTO{
        return ErrosNotFoundDTO(
            status = HttpStatus.NOT_FOUND.value(),
            erro = HttpStatus.NOT_FOUND.name,
            mensagem = exception.message,
            caminhoPath = request.servletPath)

    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidateErro(exception: MethodArgumentNotValidException, request: HttpServletRequest): ErrosNotFoundDTO{
        val mensagemErro = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach {e -> mensagemErro.put(e.field, e.defaultMessage) }
        return ErrosNotFoundDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            erro = HttpStatus.BAD_REQUEST.name,
            mensagem = mensagemErro.toString(),
            caminhoPath = request.servletPath)

    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerErro(exception: Exception, request: HttpServletRequest): ErrosNotFoundDTO{
        return ErrosNotFoundDTO(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            erro = HttpStatus.INTERNAL_SERVER_ERROR.name,
            mensagem = exception.message,
            caminhoPath = request.servletPath)

    }

}