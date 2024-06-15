package com.example.realation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ValidateBirthdateTest {
	/*
	 * @Test public void testValidDob() { String validDob = "1990-01-31";
	 * assertTrue(Validate.isBirthDateValid(validDob)); }
	 * 
	 * @Test public void testInvalidFormat() { String invalidDob = "invalid-format";
	 * assertFalse(Validate.isBirthDateValid(invalidDob)); }
	 * 
	 * @Test public void testFutureDate() { String futureDob = "2025-01-01";
	 * assertFalse(Validate.isBirthDateValid(futureDob)); }
	 * 
	 * @Test public void testLessThanSixMonthsOld() { String recentDob =
	 * "2024-01-01"; assertFalse(Validate.isBirthDateValid(recentDob)); }
	 * 
	 * @Test public void testExactlySixMonthsOld() { // Adjust date based on current
	 * date LocalDate sixMonthsAgo = LocalDate.now().minusMonths(7); String
	 * sixMonthsOldDob =
	 * sixMonthsAgo.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 * assertTrue(Validate.isBirthDateValid(sixMonthsOldDob)); }
	 */
	/*
	 * private final SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * @Test public void testValidDate() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-1990"); boolean isValid = Validate.isDateValid(dob);
	 * Assertions.assertTrue(isValid); }
	 * 
	 * @Test public void testNullDate() { boolean isValid =
	 * Validate.isDateValid(null); Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testFutureDate() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-2050"); boolean isValid = Validate.isDateValid(dob);
	 * Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testInvalidAgeMin() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-2024"); // Today's year boolean isValid =
	 * Validate.isDateValid(dob); Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testInvalidAgeMax() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-1814"); boolean isValid = Validate.isDateValid(dob);
	 * Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testValidAgeMin() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-2018"); boolean isValid = Validate.isDateValid(dob);
	 * Assertions.assertTrue(isValid); }
	 * 
	 * @Test public void testValidAgeMax() throws ParseException { Date dob =
	 * dateFormat.parse("01-01-1914"); boolean isValid = Validate.isDateValid(dob);
	 * Assertions.assertTrue(isValid); }
	 */

	/*
	 * @Test public void testValidDate() { Date dob = new Date(1990, 0, 1); // Year
	 * 1990, Month 0 (January), Day 1 System.out.println(dob); boolean isValid =
	 * Validate.isAgeValide(dob); Assertions.assertTrue(isValid); }
	 * 
	 * @Test public void testNullDate() { boolean isValid =
	 * Validate.isAgeValide(null); Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testInvalidAgeMin() { // Today's year Date dob = new
	 * Date(); boolean isValid = Validate.isAgeValide(dob);
	 * Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testInvalidAgeMax() { Date dob = new Date(1814, 0, 1); //
	 * Year 1814, Month 0 (January), Day 1 boolean isValid =
	 * Validate.isAgeValide(dob); Assertions.assertFalse(isValid); }
	 * 
	 * @Test public void testValidAgeMin() { Date dob = new Date(2018, 0, 1); //
	 * Year 2018, Month 0 (January), Day 1 boolean isValid =
	 * Validate.isAgeValide(dob); Assertions.assertTrue(isValid); }
	 * 
	 * @Test public void testValidAgeMax() { Date dob = new Date(1914, 0, 1); //
	 * Year 1914, Month 0 (January), Day 1 boolean isValid =
	 * Validate.isAgeValide(dob); Assertions.assertTrue(isValid); }
	 */

	@Test
	public void testValidAge() {
		// Test case for a valid age within the range (30 years old)
		assertTrue(Validate.isBirthdateValid(1994, 6, 14));
	}

	@Test
	public void testUnderAge() {
		// Test case for an underaged person (5 years old)
		assertFalse(Validate.isBirthdateValid(2019, 6, 14));
	}

	@Test
	public void testOverAge() {
		// Test case for an overaged person (111 years old)
		assertFalse(Validate.isBirthdateValid(1913, 6, 14));
	}

	@Test
	public void testBirthdayNotPassedThisYear() {
		// Test case for a person whose birthday hasn't happened this year yet (age
		// should be 29)
		LocalDate today = LocalDate.now();
		if (today.getMonthValue() < 6 || (today.getMonthValue() == 6 && today.getDayOfMonth() < 14)) {
			// Adjust test date if birthday hasn't passed yet
			assertTrue(Validate.isBirthdateValid(1995, 6, 14));
		} else {
			// Otherwise, test with original date
			assertTrue(Validate.isBirthdateValid(1994, 6, 14));
		}
	}

}
