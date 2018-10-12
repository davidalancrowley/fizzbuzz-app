package org.serviceflow.example.fizzbuzz.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests application by starting at the entry point (the Servlet) and checking the final response.
 * 
 * @author Dave
 *
 */
public class RoundTripTest {
	
	@Test
	public void roundTripTestSuccess() {
		final FizzBuzzService service = new FizzBuzzService();
				
		Assertions.assertTrue("1,fizz,buzz,fizzbuzz,11,101,fizz".equals(service.go("1,3,5,15,11,101,3")));
	}
	
	@Test
	public void roundTripTestFailure() {
		final FizzBuzzService service = new FizzBuzzService();
		
		Assertions.assertTrue(ErrorMessages.VALIDATION_ERROR.equals(service.go("aasdadasd")));
	}
	
}
