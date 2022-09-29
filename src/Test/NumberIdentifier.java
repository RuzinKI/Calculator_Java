package Test;

import java.util.List;

public class NumberIdentifier {

    static boolean isArabicNumber(String number1, String number2) {
        List<String> arabicNumbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        return arabicNumbers.contains(number1) && arabicNumbers.contains(number2);
    }

    static boolean isRomanNumber(String number1, String number2) {
        List<String> romanNumbers = List.of("I", "II", "III", "IV", "V", "VI", "VII", "IIX", "IX", "X");
        return romanNumbers.contains(number1) && romanNumbers.contains(number2);
    }

}
