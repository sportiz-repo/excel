package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidateNameTest {

	@Test
	public void testValidBasicName() {
		String[] validNames = {"Prasanta Kumar", "Nath","John Doe", "Jane Doe-Smith", "O'Brian", "Mr.  Sandeepan" };
		for (String name : validNames) {
			assertTrue(Validate.isNameValide(name));
		}
	}

	@Test
	public void testInvalidBasicName() {
		String[] invalidNames = { null, "", "123", "!@#$%^", "John, Doe" };
		for (String name : invalidNames) {
			assertFalse(Validate.isNameValide(name));
		}
	}

	@Test
	public void testValidNameWithCapitalization() {
		String[] validNames = { "John Doe", "Jane Doe-Smith", "O'Brian" };
		for (String name : validNames) {
			assertTrue(Validate.isNameValide(name));
		}
	}

}
