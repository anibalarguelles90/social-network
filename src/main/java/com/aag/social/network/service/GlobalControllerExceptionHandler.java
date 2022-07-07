package com.aag.social.network.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger LOG = LogManager.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object noHandlerFoundException(Exception e) {
		LOG.error(e);
		return new ResponseEntity<>("Error 404 ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object unknownException(Exception e) {
		LOG.error(e);
		return new ResponseEntity<>("Ocurrio un error no controlado", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { SocialNetWorkException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object BusinessException(Exception e) {
		LOG.error(e);
		return new ResponseEntity<>("Ocurrio un error al procesar la peticion, ver log", HttpStatus.BAD_REQUEST);
	}
}
