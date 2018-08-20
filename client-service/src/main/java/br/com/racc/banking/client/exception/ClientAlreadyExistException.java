package br.com.racc.banking.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientAlreadyExistException(final Long sin) {
		super("Client with SIN '" + sin + "' already sign up.");
	}
}
