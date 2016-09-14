# number-to-word
A java library to convert numbers to their word equivalents.
Currently there is two languages implemented such as Turkish and English.
Other languages can be implemented by extending AbstractNumberToWord.java

See also test classes :

	EnglishNumberToWordTests.java
	TurkishNumberToWordTests.java

Usage:
    
    TurkishNumberToWord toWords = new TurkishNumberToWord();
    String number = "32643";
    String output = toWords.readDigits(number);
    //output => otuz iki bin altı yüz kırk üç
    
    //Also for english is implemented
    EnglishNumberToWord toWords = new EnglishNumberToWord();
    String number = "32643";
    String output = toWords.readDigits(number);
    //output => thirty two thousand six hundred fourty three
    
Wanna see some cool stuff? Try this:

	EnglishNumberToWord toWords = new EnglishNumberToWord();
	String number = "007";
	String output = toWords.readDigitsWithLeadingZeros(number);
	System.out.println("My name is Bond, "+output+" James Bond!");
    
