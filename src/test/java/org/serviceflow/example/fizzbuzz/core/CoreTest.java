package org.serviceflow.example.fizzbuzz.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
		final String coreResult = Core.giveOutput("1,3,5,15,11,101,3");
		
		Assertions.assertTrue(coreResult.equalsIgnoreCase("1,fizz,buzz,fizzbuzz,11,101,fizz"));
	}

}