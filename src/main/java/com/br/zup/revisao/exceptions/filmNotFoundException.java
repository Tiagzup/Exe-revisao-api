package com.br.zup.revisao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class filmNotFoundException  extends RuntimeException{
	public filmNotFoundException (String mensagem) {
		super (mensagem);
	}
}
