package com.wmedya.javatools.numbertoword.lang;

import com.wmedya.javatools.numbertoword.AbstractNumberToWord;

public class EnglishNumberToWord extends AbstractNumberToWord {

	// coming from latin numerals is used in english
	private String[] tuples = new String[] { "", "", "double", "triple", "quadruple", "quintuple", "sextuple", "septuple", "octuple", "nonuple",
			"decuple", "undecuple", "duodecuple", "tredecuple" };

	public EnglishNumberToWord() {
		addDigits("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
		addTens("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
		addHundreds("", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety");
		addScales("", "ten", "hundred", "thousand", "thousand", "thousand", "million", "million", "million", "billion", "billion", "billion",
				"trillion", "trillion", "trillion", "quadrillion", "quadrillion", "quadrillion", "quintillion", "quintillion", "quintillion",
				"sextillion", "sextillion", "sextillion");
	}

	public String readDigits(String text) {

		StringBuilder sb = new StringBuilder();

		if (text.startsWith("0")) {
			if (Integer.parseInt(text) == 0) {
				return "";
			}
			text = String.valueOf(Integer.parseInt(text));
		}

		int length = text.length();
		if (length == 0) {
			sb.append("");
		}

		if (length == 1) {
			sb.append(digits[Integer.parseInt(text) % 10]);
		}

		if (length == 2) {
			int division = Integer.parseInt(text) / 10;
			if (division == 1) {
				sb.append(tens[Integer.parseInt(text.substring(1))]);
			} else {
				sb.append(hundreds[division]);
				sb.append(" ");
				sb.append(readDigits(text.substring(1)));
			}
		}

		if (length == 3) {
			int division = Integer.parseInt(text) / 100;
			sb.append(digits[division]);
			sb.append(" ");
			sb.append(scales[length - 1]);
			sb.append(" ");
			sb.append(readDigits(text.substring(1)));
		}

		if (length == 4) {
			int division = Integer.parseInt(text) / 1000;
			sb.append(digits[division]);
			sb.append(" ");
			sb.append(scales[length - 1]);
			sb.append(" ");
			sb.append(readDigits(text.substring(1)));
		}

		if (length > 4) {
			Number division = calculateDivison(text);
			if (division.intValue() < 10) {
				sb.append(digits[division.intValue()]);
				sb.append(" ");
			} else {
				sb.append(readDigits(String.valueOf(division)));
				sb.append(" ");
			}
			sb.append(scales[length - 1]);
			sb.append(" ");
			sb.append(readDigits(text.substring(String.valueOf(division).length())));
		}

		return sb.toString().trim();
	}

	public String readDigitsWithLeadingZeros(String text) {
		StringBuilder sb = new StringBuilder();
		if (text.startsWith("0")) {
			String[] split = text.split("[1-9]");
			String zerosPart = split[0];
			String nonZerosPart = text.replaceFirst(zerosPart, "");
			if (zerosPart.length() > 13) {
				sb.append("very very oh");
			} else {
				sb.append(tuples[zerosPart.length()] + " oh");
			}
			sb.append(" ");
			if (!nonZerosPart.isEmpty()) {
				sb.append(readDigits(nonZerosPart));
			}
			return sb.toString().trim();
		}
		return "";
	}

}
