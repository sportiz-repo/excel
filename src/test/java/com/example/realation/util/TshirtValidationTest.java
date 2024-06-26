package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TshirtValidationTest {
	@Test
	public void testValidSizes() {
		assertEquals("XXS", Validate.validateSize("xxs"));
		assertEquals("XS", Validate.validateSize("XS"));
		assertEquals("S", Validate.validateSize("s"));
		assertEquals("M", Validate.validateSize("M"));
		assertEquals("L", Validate.validateSize("l"));
		assertEquals("XL", Validate.validateSize("XL"));
		assertEquals("XXL", Validate.validateSize("xxl"));
		assertEquals("XXXL", Validate.validateSize("XXXl"));
	}

	@Test
	public void testInvalidSizes() {
		assertEquals("M", Validate.validateSize("abcd"));
		assertEquals("M", Validate.validateSize("small"));
		assertEquals("M", Validate.validateSize("large"));
		assertEquals("M", Validate.validateSize("extra large"));
	}

	@Test
	public void testNullAndEmptyInput() {
		assertEquals("M", Validate.validateSize(null));
		assertEquals("M", Validate.validateSize(""));
		assertEquals("M", Validate.validateSize(" "));
	}

	@Test
	public void testCaseInsensitiveInput() {
		assertEquals("XXS", Validate.validateSize("xXs"));
		assertEquals("XXS", Validate.validateSize("XxS"));
		assertEquals("S", Validate.validateSize("S"));
		assertEquals("M", Validate.validateSize("m"));
		assertEquals("L", Validate.validateSize("l"));
		assertEquals("XL", Validate.validateSize("xL"));
		assertEquals("XXL", Validate.validateSize("XXl"));
		assertEquals("XXXL", Validate.validateSize("xxXl"));
	}
}
