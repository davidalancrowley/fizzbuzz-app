package org.serviceflow.example.fizzbuzz.core;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 2923162034356816894L;

	public ValidationException(String errorMsg) {
		super(errorMsg);
	}
}
