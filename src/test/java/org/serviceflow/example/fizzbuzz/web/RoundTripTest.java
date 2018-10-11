package org.serviceflow.example.fizzbuzz.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundTripTest {
	
	@Test
	public void roundTripTestSuccess() {
		final FizzBuzzService playObj = new FizzBuzzService();
				
		Assertions.assertTrue("1,fizz,buzz,fizzbuzz,11,101,fizz".equals(playObj.go("1,3,5,15,11,101,3")));
	}
	
	@Test
	public void roundTripTestFailure() {
		final FizzBuzzService playObj = new FizzBuzzService();
		
		Assertions.assertTrue(ErrorMessages.VALIDATION_ERROR.equals(playObj.go("aasdadasd")));
	}
	
}
