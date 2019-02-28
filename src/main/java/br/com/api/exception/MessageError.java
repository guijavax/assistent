package br.com.api.exception;

public class MessageError {
	
	private String userMessage;
	private String developerMessage;
	
	public MessageError (String userMessage, String developerMessage) {
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}
}
