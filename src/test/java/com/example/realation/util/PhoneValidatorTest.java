package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PhoneValidatorTest {
	@Test
	public void testValidMobileNumber() {
		String mobileNumber = "7890123456";
		assertTrue(Validate.isValidIndianMobileNumber(mobileNumber), "Valid mobile number should be accepted");
	}

	@Test
	public void testEmptyMobileNumber() {
		String mobileNumber = "";
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber), "Empty mobile number should be rejected");
	}

	@Test
	public void testNullMobileNumber() {
		String mobileNumber = null;
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber), "Null mobile number should be rejected");
	}

	@Test
	public void testInvalidLength() {
		String mobileNumber = "1234567890"; // 9 digits (not valid)
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber),
				"Mobile number with invalid length should be rejected");

		mobileNumber = "12345678901"; // 11 digits (not valid)
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber),
				"Mobile number with invalid length should be rejected");
	}

	@Test
	public void testInvalidStartingDigit() {
		String mobileNumber = "0123456789"; // Starts with 0 (not valid)
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber),
				"Mobile number with invalid starting digit should be rejected");

		mobileNumber = "5890123456"; // Starts with 5 (not valid)
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber),
				"Mobile number with invalid starting digit should be rejected");
	}

	@Test
	public void testWithPlus() {
		String mobileNumber = "+91890123456"; // Invalid with +91 prefix
		assertFalse(Validate.isValidIndianMobileNumber(mobileNumber),
				"Mobile number with +91 prefix should be rejected");
	}
}
