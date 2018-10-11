package org.serviceflow.example.fizzbuzz.core;

import java.util.StringJoiner;

import org.junit.platform.commons.util.StringUtils;

public class Core {
	
	private static final String LIST_VALIDATION_REGEX = "^([0-9]*,)*[0-9]*$";
	private static final String LIST_DELIMITER        = ",";
	
	public static String giveOutput(final String numberList) {

		final String[] numbers = numberList.split(LIST_DELIMITER);	
		
		final StringJoiner formattedReturnList = new StringJoiner(LIST_DELIMITER);
		
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
	
	public static void validateData(final String data) throws ValidationException {
		if (StringUtils.isBlank(data) || !data.matches(LIST_VALIDATION_REGEX)) {
			throw new ValidationException("Incorrect format");
		}
	}
}