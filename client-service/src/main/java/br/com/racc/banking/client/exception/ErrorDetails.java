package br.com.racc.banking.client.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ErrorDetails {
	private static final String URI_PREFIX = "uri=";
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private List<String> messages;
	private String path;

	public ErrorDetails(Integer status, Exception exception, String path) {
		super();
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.error = formatError(exception);
		this.messages = formatMessage(exception);
		this.path = formatPath(path);
	}

	protected List<String> formatMessage(Exception exception) {
		List<String> messages = new ArrayList<String>();
		messages.add(exception.getMessage());
		return messages;
	}

	protected String formatError(Exception exception) {
		return exception.getMessage();
	}

	private String formatPath(String path) {
		return path != null ? path.replace(URI_PREFIX, "") : null;
	}
}