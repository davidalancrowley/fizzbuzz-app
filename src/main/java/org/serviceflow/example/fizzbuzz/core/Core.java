package org.serviceflow.example.fizzbuzz.core;

import java.util.StringJoiner;

import org.junit.platform.commons.util.StringUtils;

/**
 * 
 * Provides the core functionality for the application. 
 * Is responsible for handling and converting the data retrieved by the Servlet.
 * 
 * @author Dave
 *
 */
public class Core {
	
	private static final String LIST_VALIDATION_REGEX = "^([0-9]*,)*[0-9]*$";
	private static final String LIST_DELIMITER        = ",";
	
	/**
	 * 
	 * Takes in numberic data and converts it to the fizzbuzz format.
	 * 
	 * @param numberList List of numbers to be formatted
	 * @return Number list converted to the fizzbuzz format
	 */
	public static String convertToFizzBuzzFormat(final String numberList) {

		final String[] numbers = numberList.split(LIST_DELIMITER);	
		
		final StringJoiner formattedReturnList = new StringJoiner(LIST_DELIMITER);
		
		// Convert array of numbers to fizzbuzz format
		for (int count = 0; count < numbers.length; count++) {
			
			final int number = Integer.parseInt(numbers[count]);
			
			final boolean isDivisibleByThree = number % 3 == 0;
			final boolean isDivisibleByFive  = number % 5 == 0;
			
			if (isDivisibleByThree && isDivisibleByFive) {
				formattedReturnList.add("fizzbuzz");
			} else if (isDivisibleByThree) {
				formattedReturnList.add("fizz");
			} else if (isDivisibleByFive) {
				formattedReturnList.add("buzz");
			} else {
				formattedReturnList.add(numbers[count]);
			}
			
		}
		
		return formattedReturnList.toString();
	}
	
	/**
	 * 
	 * Makes sure that the provide String conforms the usable format.
	 * 
	 * @param data String data taken in from the Servlet
	 * @throws ValidationException
	 */
	public static void validateData(final String data) throws ValidationException {

		if (StringUtils.isBlank(data) || !data.matches(LIST_VALIDATION_REGEX)) {
			throw new ValidationException("Incorrect format");
		}
		
	}
	
	/**
	 * 
	 * Removes unneeded characters from the data.
	 * 
	 * @param numberList Sanitize the provided String input so that it can be used properly
	 * @return Return sanitized input
	 */
	public static String sanitizeData(final String numberList) {
		return numberList.replaceAll("\\s","");
	}
}