package br.com.racc.banking.client.exception;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ErrorDetailsMethodArgumentNotValid extends ErrorDetails {

	public ErrorDetailsMethodArgumentNotValid(int status, Exception exception, String details) {
		super(status, exception, details);
	}

	protected List<String> formatMessage(Exception exception) {
		return ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage).collect(toList());
	}

	protected String formatError(Exception exception) {
		return "Validation failed";
	}
}
