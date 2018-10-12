package org.serviceflow.example.fizzbuzz.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests the core functionality of the application.
 * 
 * @author Dave
 *
 */
public class CoreTest {

	@Test
	public void testValidation() {
		// Failure cases
		Assertions.assertThrows(ValidationException.class, () -> { Core.validateData("aasdasdasd"); });	    
		Assertions.assertThrows(ValidationException.class, () -> { Core.validateData("a,2,4,7"); });
	    
		// Pass cases
		Assertions.assertAll( () -> Core.validateData("1,2,4,7"));
		Assertions.assertAll( () -> Core.validateData("1,2,4,7,"));
		Assertions.assertAll( () -> Core.validateData("1"));
	}
	
	@Test
	public void testCoreFunctionality() {
		final String coreResult = Core.convertToFizzBuzzFormat("1,3,5,15,11,101,3,0");
		
		Assertions.assertTrue(coreResult.equalsIgnoreCase("1,fizz,buzz,fizzbuzz,11,101,fizz,fizzbuzz"));
	}
	
	@Test
	public void testDataSanitization() {
		final String sanitizationResult = Core.sanitizeData(" 12,35, 23,2   ");
		
		Assertions.assertTrue(sanitizationResult.equals("12,35,23,2"));
	}

}