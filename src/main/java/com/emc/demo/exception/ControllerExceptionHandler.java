package com.emc.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//Aquesta anotació fa que escolti tots els RestControllers definits
@RestControllerAdvice
public class ControllerExceptionHandler {
	
	//Convertim l'excepció a un codi d'error HTTP
	//Estem fent un tractament específic per la nostra excepció
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(),
				new Date(), ex.getMessage(), request.getDescription(false) );
		return message;
	}

	//Aquest seria el tractament per defecte d'excepcions
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage globalException(Exception ex,
			WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(), ex.getMessage(), request.getDescription(false) );
		return message;
	}
	
}
