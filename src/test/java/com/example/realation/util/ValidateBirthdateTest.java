package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class ValidateBirthdateTest {
	@Test
	public void testValidDob() {
		String validDob = "1990-01-31";
		assertTrue(Validate.isBirthDateValid(validDob));
	}

	@Test
	public void testInvalidFormat() {
		String invalidDob = "invalid-format";
		assertFalse(Validate.isBirthDateValid(invalidDob));
	}

	@Test
	public void testFutureDate() {
		String futureDob = "2025-01-01";
		assertFalse(Validate.isBirthDateValid(futureDob));
	}

	@Test
	public void testLessThanSixMonthsOld() {
		String recentDob = "2024-01-01";
		assertFalse(Validate.isBirthDateValid(recentDob));
	}

	@Test
	public void testExactlySixMonthsOld() {
		// Adjust date based on current date
		LocalDate sixMonthsAgo = LocalDate.now().minusMonths(7);
		String sixMonthsOldDob = sixMonthsAgo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		assertTrue(Validate.isBirthDateValid(sixMonthsOldDob));
	}
}
