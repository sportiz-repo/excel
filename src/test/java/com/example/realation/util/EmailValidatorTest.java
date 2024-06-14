package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailValidatorTest {

	@Test
	public void testValidEmail() {
		String email = "valid@example.com";
		assertTrue(Validate.isEmailValid(email), "Valid email should be accepted");
	}

	@Test
	public void testEmptyEmail() {
		String email = "";
		assertFalse(Validate.isEmailValid(email), "Empty email should be rejected");
	}

	@Test
	public void testNullEmail() {
		String email = null;
		assertFalse(Validate.isEmailValid(email), "Null email should be rejected");
	}

	@Test
	public void testShortEmail() {
		String email = "a@de.co"; // Length 7 (not valid)
		assertFalse(Validate.isEmailValid(email), "Email shorter than 8 characters should be rejected");
	}

	@Test
	public void testLongEmail() {
		String email = "very_long_email_address@this.is.a.very.long.domain.com"; // Length 49 (not valid)
		assertFalse(Validate.isEmailValid(email), "Email longer than 35 characters should be rejected");
	}

	@Test
	public void testInvalidFormat() {
		String email = "invalid.email"; // Missing "@" symbol
		assertFalse(Validate.isEmailValid(email), "Email with invalid format should be rejected");
	}

	@Test
	public void testSpecialCharacters() {
		String email = "valid.email!#$%&'*+@example.com";
		assertTrue(Validate.isEmailValid(email), "Email with allowed special characters should be accepted");
	}
}