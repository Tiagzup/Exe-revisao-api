package com.br.zup.revisao.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.zup.revisao.exceptions.filmNotFoundException;
import com.br.zup.revisao.helpers.DetailsError;

@RestController
@ControllerAdvice
public class FilmControllerAdvice {
	@ExceptionHandler(filmNotFoundException.class)
	public ResponseEntity<DetailsError> handleFilmNotFoundException(filmNotFoundException e,
			WebRequest requisicao) {
		DetailsError detailsError = new DetailsError(HttpStatus.NOT_FOUND, e.getMessage(), 
				requisicao.getDescription(false));
		return ResponseEntity.status(detailsError.getStatus()).body(detailsError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetailsError> handleMethodArgumentNotValidException (MethodArgumentNotValidException e,
			WebRequest requisicao){
		DetailsError detailsError = new DetailsError(HttpStatus.BAD_REQUEST, e.getMessage(),
				requisicao.getDescription(false));
		return ResponseEntity.status(detailsError.getStatus()).body(detailsError);
		
	}
	
}

