package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TshirtValidationTest {
	@Test
	public void testValidSizes() {
		assertEquals("XXS", Validate.validateTshirtSize("xxs"));
		assertEquals("XS", Validate.validateTshirtSize("XS"));
		assertEquals("S", Validate.validateTshirtSize("s"));
		assertEquals("M", Validate.validateTshirtSize("M"));
		assertEquals("L", Validate.validateTshirtSize("l"));
		assertEquals("XL", Validate.validateTshirtSize("XL"));
		assertEquals("XXL", Validate.validateTshirtSize("xxl"));
		assertEquals("XXXL", Validate.validateTshirtSize("XXXl"));
	}

	@Test
	public void testInvalidSizes() {
		assertEquals("M", Validate.validateTshirtSize("abcd"));
		assertEquals("M", Validate.validateTshirtSize("small"));
		assertEquals("M", Validate.validateTshirtSize("large"));
		assertEquals("M", Validate.validateTshirtSize("extra large"));
	}

	@Test
	public void testNullAndEmptyInput() {
		assertEquals("M", Validate.validateTshirtSize(null));
		assertEquals("M", Validate.validateTshirtSize(""));
		assertEquals("M", Validate.validateTshirtSize(" "));
	}

	@Test
	public void testCaseInsensitiveInput() {
		assertEquals("XXS", Validate.validateTshirtSize("xXs"));
		assertEquals("XXS", Validate.validateTshirtSize("XxS"));
		assertEquals("S", Validate.validateTshirtSize("S"));
		assertEquals("M", Validate.validateTshirtSize("m"));
		assertEquals("L", Validate.validateTshirtSize("l"));
		assertEquals("XL", Validate.validateTshirtSize("xL"));
		assertEquals("XXL", Validate.validateTshirtSize("XXl"));
		assertEquals("XXXL", Validate.validateTshirtSize("xxXl"));
	}
}
