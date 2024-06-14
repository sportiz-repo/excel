package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidateChipNumberTest {
	@Test
	public void testValidString() {
		String validString = "1234567";
		assertTrue(Validate.idChipValide(validString));
	}

	@Test
	public void testEmptyString() {
		String emptyString = "";
		assertFalse(Validate.idChipValide(emptyString));
	}

	@Test
	public void testNullString() {
		String nullString = null;
		assertFalse(Validate.idChipValide(nullString));
	}

	@Test
	public void testInvalidLength() {
		String invalidLengthString = "123456";
		assertFalse(Validate.idChipValide(invalidLengthString));
	}

	@Test
	public void testNonNumericCharacters() {
		String nonNumericString = "123abc456";
		assertFalse(Validate.idChipValide(nonNumericString));
	}
	@Test
	public void testNumericCharactersStartsWithZero() {
		String nonNumericString = "0057981";
		assertTrue(Validate.idChipValide(nonNumericString));
	}
}
