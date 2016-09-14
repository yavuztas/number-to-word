package com.wmedya.javatools.numbertoword.lang;

import com.wmedya.javatools.numbertoword.AbstractNumberToWord;

public class TurkishNumberToWord extends AbstractNumberToWord {

	public TurkishNumberToWord() {
		addDigits("sıfır", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz");
		addHundreds("", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan");
		addScales("", "on", "yüz", "bin", "bin", "bin", "milyon", "milyon", "milyon", "milyar", "milyar", "milyar", "trilyon", "trilyon", "trilyon",
				"katrilyon", "katrilyon", "katrilyon", "kentilyon", "kentilyon", "kentilyon", "seksilyon", "seksilyon", "seksilyon");
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
			sb.append(hundreds[Integer.parseInt(text) / 10]);
			sb.append(" ");
			sb.append(readDigits(text.substring(1)));
		}

		if (length == 3) {
			int division = Integer.parseInt(text) / 100;
			if (division > 1) {
				sb.append(digits[division]);
				sb.append(" ");
			}
			sb.append(scales[length - 1]);
			sb.append(" ");
			sb.append(readDigits(text.substring(1)));
		}

		if (length == 4) {
			int division = Integer.parseInt(text) / 1000;
			if (division > 1) {
				sb.append(digits[division]);
				sb.append(" ");
			}
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
			// read every single zero one by one
			for (char c : zerosPart.toCharArray()) {
				sb.append(digits[Integer.parseInt(String.valueOf(c))]);
				sb.append(" ");
			}
			if (!nonZerosPart.isEmpty()) {
				sb.append(readDigits(nonZerosPart));
			}
			return sb.toString().trim();
		}
		return "";
	}

}
