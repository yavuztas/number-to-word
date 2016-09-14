# number-to-word
A java library to convert numbers to their word equivalents

Usage:
    
    TurkishNumberToWord toWords = new TurkishNumberToWord();
    String number = "32643";
    String output = toWords.readDigits(number);
    //output => otuz iki bin altı yüz kırk üç
    
    //Also for english is implemented
    EnglishNumberToWord toWords = new EnglishNumberToWord();
    String number = "32643";
    String output = toWords.readDigits(number);
    //output => 
    
