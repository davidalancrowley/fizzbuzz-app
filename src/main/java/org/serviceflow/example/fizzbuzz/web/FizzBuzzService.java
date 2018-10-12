package org.serviceflow.example.fizzbuzz.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.serviceflow.example.fizzbuzz.core.Core;
import org.serviceflow.example.fizzbuzz.core.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Handles any requests and creates their associated response.
 * 
 * @author Dave
 * 
 */
@Path("/fizzit")
public class FizzBuzzService {
	
	final Logger log = LoggerFactory.getLogger(FizzBuzzService.class);
	
	/**
	 * 
	 * Takes in post requests to the application and returns a response.
	 * 
	 * @param numberList Data from the form as a list of numbers
	 * @return Returns either an error message or the correctly formatted result
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String go(@FormParam("numbers") String numberList) {		
		
		log.info("Request received: {}", numberList);
		
		String returnMessage;
		
		try {
			numberList = Core.sanitizeData(numberList);
			
			Core.validateData(numberList);
			
			returnMessage = Core.convertToFizzBuzzFormat(numberList);
		} catch (ValidationException e) {
			returnMessage = ErrorMessages.VALIDATION_ERROR; 
		} catch (Exception e) {
			log.error("Unexpected Exception occurred: {}", e.getMessage());
			
			returnMessage = ErrorMessages.UNKNOWN_ERROR;
		}
		
		log.info("Response: {}", returnMessage);
		
		return returnMessage;
	}
	
}