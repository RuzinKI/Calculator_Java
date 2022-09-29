package Test;

import Test.exception.NonPositiveResult;

import java.io.IOException;
import java.util.List;

public class RomanCalcs extends Calculations {

    @Override
    public int addition(int x, int y) {
        return x+y;
    }

    @Override
    public int subtraction(int x, int y) throws NonPositiveResult {
        if (x<=y) {
            throw new NonPositiveResult();
        }
        return x-y;
    }

    @Override
    public int multiplication(int x, int y) {
        return x*y;
    }

    @Override
    public int division(int x, int y) throws IOException {
        int execute = x/y;
        if (execute == 0) {
            throw new IOException("Результат ноль");
        }
        return execute;
    }

    public static int romanToArabic(String number) {
        List<String> romanNumbers = List.of("","I", "II", "III", "IV", "V", "VI", "VII", "IIX", "IX", "X");
        return romanNumbers.indexOf(number.toUpperCase());
    }

    public static String arabicToRoman(int number)  {
        String roman;
        List<String> str1 = List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "IIX", "IX");
        List<String> str2 = List.of("","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");

        roman = str1.get(number%10);
        number/=10;
        roman = str2.get(number) + roman;

        return roman;
    }
}
