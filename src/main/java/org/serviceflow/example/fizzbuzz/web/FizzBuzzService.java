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
 
@Path("/play")
public class FizzBuzzService {
	
	final Logger log = LoggerFactory.getLogger(FizzBuzzService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String go(@FormParam("numbers") final String numberList) {		
		
		log.info("Request received: {}", numberList);
		
		String returnMessage;
		
		try {		
			Core.validateData(numberList);
			
			returnMessage = Core.giveOutput(numberList);
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