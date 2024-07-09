package com.example.realation.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	private static final Set<String> VALID_SIZES = new HashSet<>(
			Arrays.asList("XXS", "XS", "S", "M", "L", "XL", "XXL", "XXXL"));

	public static boolean isNameValide(String name) {
		if (name == null || name.isBlank()) {
			return false;
		}

		String regex = "^[A-Za-z]+[ A-Za-z'.-]*$";
		return name.length() >= 2 && name.length() <= 30 && name.matches(regex);
	}

	public static boolean isChipValide(String chipNumber) {
		if (chipNumber == null || chipNumber.isBlank()) {
			return false;
		}
		if (chipNumber.length() != 7) {
			return false;
		}
		for (char cN : chipNumber.toCharArray()) {
			if (!Character.isDigit(cN)) {
				return false;
			}
		}
		return true;
	}

	public static String validateGender(String gender) {
		if (gender == null || gender.isEmpty()) {
			return "NA";
		}
		gender = gender.toLowerCase();
		switch (gender) {
		case "male", "m":
			return "M";
		case "female", "f":
			return "F";
		case "other", "o":
			return "O";
		default:
			return "NA";
		}
	}

	public static boolean isCityOrContryValide(String city) {
		if (city == null || city.isEmpty()) {
			return false;
		}
		if (city.length() < 2)
			return false;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
		return pattern.matcher(city).matches();
	}


	public static boolean isBirthdateValid(int year, int month, int day) {
		LocalDate birthDate = LocalDate.of(year, month, day);
		LocalDate today = LocalDate.now();
		int age = today.getYear() - birthDate.getYear();

		// Check if the birthday has not happened this year yet
		if (birthDate.isAfter(today.withYear(year))) {
			age--;
		}

		return age >= 6 && age <= 110;
	}

	public static boolean isEmailValid(String email) { // Renamed to isEmailValid
		if (email == null || email.isEmpty()) {
			return false; // Empty email is not valid
		}

		int length = email.length();
		if (length < 8 || length > 35) {
			return false; // Doesn't meet length requirement
		}

		// Regex for basic email validation
		String emailRegex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	public static boolean isValidIndianMobileNumber(String mobileNumber) {
		if (mobileNumber == null || mobileNumber.isEmpty()) {
			return false; // Empty string is not a valid mobile number
		}
		
		

		// Regex pattern for Indian mobile numbers (includes optional +91 or 0)
		String pattern = "^[6-9]\\d{9}$";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(mobileNumber);
		return matcher.matches();
	}

	public static String validateTshirtSize(String input) {
		// Check if input is null or empty
		if (input == null || input.trim().isEmpty()) {
			return "M";
		}

		// Convert input to uppercase
		String size = input.trim().toUpperCase();

		// Check if the size is valid
		if (VALID_SIZES.contains(size)) {
			return size;
		}

		// Return default size "M" if the input is not valid
		return "M";
	}
}
