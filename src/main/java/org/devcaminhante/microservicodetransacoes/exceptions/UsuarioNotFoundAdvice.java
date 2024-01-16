package org.devcaminhante.microservicodetransacoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNotFoundAdvice{ 
	@ResponseBody
	@ExceptionHandler(UsuarioNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String usuarioNotFoundHandler(UsuarioNotFoundException exception) {
		return exception.getMessage();
	}
}
