package com.wmedya.javatools.test;

import org.junit.Before;
import org.junit.Test;

import com.wmedya.javatools.numbertoword.lang.EnglishNumberToWord;

import junit.framework.Assert;

public class EnglishNumberToWordTests {

	private EnglishNumberToWord toWords;

	@Before
	public void setUp() {
		toWords = new EnglishNumberToWord();
	}

	@Test
	public void oneDigitNumberTest() {
		String number = "6";
		String output = toWords.readDigits(number);
		Assert.assertEquals("six", output);
	}

	@Test
	public void twoDigitsBelowTwentyNumberTest() {
		String number = "15";
		String output = toWords.readDigits(number);
		Assert.assertEquals("fifteen", output);
	}

	@Test
	public void twoDigitsLastOneZeroNumberTest() {
		String number = "70";
		String output = toWords.readDigits(number);
		Assert.assertEquals("seventy", output);
	}

	@Test
	public void twoDigitsAboveTwentyNumberTest() {
		String number = "46";
		String output = toWords.readDigits(number);
		Assert.assertEquals("fourty six", output);
	}

	@Test
	public void threeDigitsBelowTwoHundredNumberTest() {
		String number = "156";
		String output = toWords.readDigits(number);
		Assert.assertEquals("one hundred fifty six", output);
	}

	@Test
	public void threeDigitsAboveTwoHundredNumberTest() {
		String number = "785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("seven hundred eighty five", output);
	}

	@Test
	public void fourDigitsBelowTwoThousandNumberTest() {
		String number = "1785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("one thousand seven hundred eighty five", output);
	}

	@Test
	public void fourDigitsAboveTwoThousandNumberTest() {
		String number = "2643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("two thousand six hundred fourty three", output);
	}

	@Test
	public void fiveDigitsNumberTest() {
		String number = "32643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("thirty two thousand six hundred fourty three", output);
	}

	@Test
	public void sixDigitsNumberTest() {
		String number = "132643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("one hundred thirty two thousand six hundred fourty three", output);
	}

	@Test
	public void millionsNumberTest() {
		String number = "1954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("one million nine hundred fifty four thousand seven hundred eighty five", output);

		number = "21954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("twenty one million nine hundred fifty four thousand seven hundred eighty five", output);

		number = "321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("three hundred twenty one million nine hundred fifty four thousand seven hundred eighty five", output);
	}

	@Test
	public void billionsNumberTest() {
		String number = "5321954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("five billion three hundred twenty one million nine hundred fifty four thousand seven hundred eighty five", output);

		number = "45321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("fourty five billion three hundred twenty one million nine hundred fifty four thousand seven hundred eighty five",
				output);

		number = "983321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals(
				"nine hundred eighty three billion three hundred twenty one million nine hundred fifty four thousand seven hundred eighty five",
				output);
	}

	@Test
	public void reallyBigNumberTest() {
		String number = "983321954785983321954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals(
				"nine hundred eighty three sextillion three hundred twenty one quintillion nine hundred fifty four quadrillion seven hundred eighty five trillion nine hundred eighty three billion three hundred twenty one million nine hundred fifty four thousand seven hundred eighty five",
				output);
	}

	@Test
	public void extremePointsTest() {
		String number = "70";
		String output = toWords.readDigits(number);
		Assert.assertEquals("seventy", output);

		number = "700";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven hundred", output);

		number = "701";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven hundred one", output);

		number = "7000";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven thousand", output);

		number = "7001";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven thousand one", output);

		number = "70000";
		output = toWords.readDigits(number);
		Assert.assertEquals("seventy thousand", output);

		number = "70001";
		output = toWords.readDigits(number);
		Assert.assertEquals("seventy thousand one", output);

		number = "7100010001";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven billion one hundred million ten thousand one", output);

		number = "7000000001";
		output = toWords.readDigits(number);
		Assert.assertEquals("seven billion one", output);
	}

	@Test
	public void specialCaseZerosNumberTest() {
		String number = "0";
		String output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("oh", output);

		number = "07";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("oh seven", output);

		number = "007";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("double oh seven", output);

		number = "0070";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("double oh seventy", output);

		number = "00700";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("double oh seven hundred", output);

		number = "00777";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("double oh seven hundred seventy seven", output);

		number = "0003";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("triple oh three", output);

		number = "000000003";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("octuple oh three", output);
	}

}
