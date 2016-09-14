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
	public void specialCaseZeroTest() {
		String number = "0";
		String output = toWords.readDigits(number);
		Assert.assertEquals("sıfır", output);
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

}
