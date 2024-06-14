package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CityValidatorTest {

	@Test
	public void testValidCityFormat() {
		String city = "Howrah";
		assertTrue(Validate.validateCityFormat(city));
	}

	@Test
	public void testValidCityWithHyphen() {
		String city = "San-Francisco";
		assertTrue(Validate.validateCityFormat(city));
	}

	@Test
	public void testEmptyCity() {
		String city = "";
		assertFalse(Validate.validateCityFormat(city));
	}

	@Test
	public void testCityOneChar() {
		String city = "a";
		assertFalse(Validate.validateCityFormat(city));
	}

	@Test
	public void testNullCity() {
		String city = null;
		assertFalse(Validate.validateCityFormat(city));
	}

	@Test
	public void testInvalidCityFormat() {
		String city = "123 Main St";
		assertFalse(Validate.validateCityFormat(city));
	}
}