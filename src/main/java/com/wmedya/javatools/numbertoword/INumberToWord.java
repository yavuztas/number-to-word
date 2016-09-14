package com.wmedya.javatools.numbertoword;

public interface INumberToWord {

	/**
	 * Parses a number string into word equivalents. Should be used as recursive
	 * and implementation should change according to language
	 * 
	 * @param text
	 * @return words equivalents of given number string
	 */
	public String readDigits(String text);

	/**
	 * Parses a number string into word equivalents accounting the leading
	 * zeros. For example "007" should read as "zero zero seven"
	 * 
	 * @param text
	 * @return words equivalents of given number string
	 */
	public String readDigitsWithLeadingZeros(String text);

}
