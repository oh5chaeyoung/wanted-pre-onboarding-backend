package com.wanted.prenoboarding.exception;

public class ApplicationAlreadyExistException extends RuntimeException {

	public ApplicationAlreadyExistException(String message) {
		super(message);
	}
}