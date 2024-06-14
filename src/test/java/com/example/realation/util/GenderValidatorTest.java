package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GenderValidatorTest {

	@Test
	public void testValidMaleInput() {
		String gender = "Male";
		String expected = "M";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testValidMaleLowerCase() {
		String gender = "male";
		String expected = "M";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testValidFemaleInput() {
		String gender = "Female";
		String expected = "F";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testValidOtherInput() {
		String gender = "Other";
		String expected = "O";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyInput() {
		String gender = "";
		String expected = "NA";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testNullInput() {
		String gender = null;
		String expected = "NA";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}

	@Test
	public void testInvalidInput() {
		String gender = "Invalid";
		String expected = "NA";
		String actual = Validate.validateGender(gender);
		assertEquals(expected, actual);
	}
}