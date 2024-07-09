package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidateChipNumberTest {
	@Test
	public void testValidString() {
		String validString = "1234567";
		assertTrue(Validate.isChipValide(validString));
	}

	@Test
	public void testEmptyString() {
		String emptyString = "";
		assertFalse(Validate.isChipValide(emptyString));
	}

	@Test
	public void testNullString() {
		String nullString = null;
		assertFalse(Validate.isChipValide(nullString));
	}

	@Test
	public void testInvalidLength() {
		String invalidLengthString = "123456";
		assertFalse(Validate.isChipValide(invalidLengthString));
	}

	@Test
	public void testNonNumericCharacters() {
		String nonNumericString = "123abc456";
		assertFalse(Validate.isChipValide(nonNumericString));
	}
	@Test
	public void testNumericCharactersStartsWithZero() {
		String nonNumericString = "0057981";
		assertTrue(Validate.isChipValide(nonNumericString));
	}
}
