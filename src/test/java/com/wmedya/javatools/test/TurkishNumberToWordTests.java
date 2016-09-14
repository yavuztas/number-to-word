package com.wmedya.javatools.test;

import org.junit.Before;
import org.junit.Test;

import com.wmedya.javatools.numbertoword.lang.TurkishNumberToWord;

import junit.framework.Assert;

public class TurkishNumberToWordTests {

	private TurkishNumberToWord toWords;

	@Before
	public void setUp() {
		toWords = new TurkishNumberToWord();
	}

	@Test
	public void oneDigitNumberTest() {
		String number = "6";
		String output = toWords.readDigits(number);
		Assert.assertEquals("altı", output);
	}

	@Test
	public void twoDigitsBelowTwentyNumberTest() {
		String number = "15";
		String output = toWords.readDigits(number);
		Assert.assertEquals("on beş", output);
	}

	@Test
	public void twoDigitsAboveTwentyNumberTest() {
		String number = "46";
		String output = toWords.readDigits(number);
		Assert.assertEquals("kırk altı", output);
	}

	@Test
	public void threeDigitsBelowTwoHundredNumberTest() {
		String number = "156";
		String output = toWords.readDigits(number);
		Assert.assertEquals("yüz elli altı", output);
	}

	@Test
	public void threeDigitsAboveTwoHundredNumberTest() {
		String number = "785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("yedi yüz seksen beş", output);
	}

	@Test
	public void fourDigitsBelowTwoThousandNumberTest() {
		String number = "1785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("bin yedi yüz seksen beş", output);
	}

	@Test
	public void fourDigitsAboveTwoThousandNumberTest() {
		String number = "2643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("iki bin altı yüz kırk üç", output);
	}

	@Test
	public void fiveDigitsNumberTest() {
		String number = "32643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("otuz iki bin altı yüz kırk üç", output);
	}

	@Test
	public void sixDigitsNumberTest() {
		String number = "132643";
		String output = toWords.readDigits(number);
		Assert.assertEquals("yüz otuz iki bin altı yüz kırk üç", output);
	}

	@Test
	public void millionsNumberTest() {
		String number = "1954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);

		number = "21954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);

		number = "321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("üç yüz yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);
	}

	@Test
	public void billionsNumberTest() {
		String number = "5321954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals("beş milyar üç yüz yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);

		number = "45321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("kırk beş milyar üç yüz yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);

		number = "983321954785";
		output = toWords.readDigits(number);
		Assert.assertEquals("dokuz yüz seksen üç milyar üç yüz yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş", output);
	}

	@Test
	public void reallyBigNumberTest() {
		String number = "983321954785983321954785";
		String output = toWords.readDigits(number);
		Assert.assertEquals(
				"dokuz yüz seksen üç seksilyon üç yüz yirmi bir kentilyon dokuz yüz elli dört katrilyon yedi yüz seksen beş trilyon dokuz yüz seksen üç milyar üç yüz yirmi bir milyon dokuz yüz elli dört bin yedi yüz seksen beş",
				output);
	}

	@Test
	public void extremePointsTest() {
		String number = "70";
		String output = toWords.readDigits(number);
		Assert.assertEquals("yetmiş", output);

		number = "700";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi yüz", output);

		number = "701";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi yüz bir", output);

		number = "7000";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi bin", output);

		number = "7001";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi bin bir", output);

		number = "70000";
		output = toWords.readDigits(number);
		Assert.assertEquals("yetmiş bin", output);

		number = "70001";
		output = toWords.readDigits(number);
		Assert.assertEquals("yetmiş bin bir", output);

		number = "7100010001";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi milyar yüz milyon on bin bir", output);

		number = "7000000001";
		output = toWords.readDigits(number);
		Assert.assertEquals("yedi milyar bir", output);
	}

	@Test
	public void specialCaseZerosNumberTest() {
		String number = "0";
		String output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır", output);

		number = "07";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır yedi", output);

		number = "007";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır sıfır yedi", output);

		number = "0070";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır sıfır yetmiş", output);

		number = "00700";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır sıfır yedi yüz", output);

		number = "00777";
		output = toWords.readDigitsWithLeadingZeros(number);
		Assert.assertEquals("sıfır sıfır yedi yüz yetmiş yedi", output);
	}

}
