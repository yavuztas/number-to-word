package com.wmedya.javatools.numbertoword;

public interface INumberToWord {

	/**
	 * Parses a number string into word equivalents. Should be used as recursive
	 * and implementation should change according to language
	 * 
	 * @param text
	 * @return
	 */
	public String readDigits(String text);

	/**
	 * Parses a string number as integer according to its size and calculates
	 * division by the power of thousand. Should be carefully implemented and
	 * used proper type like int, long or BigInteger considering the size of the
	 * integer.
	 * 
	 * @param text
	 * @return division by the power of thousand
	 */
	public Number calculateDivison(String text);

}
