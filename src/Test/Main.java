package Test;

import Test.exception.InvalidNumberFormat;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Test.NumberIdentifier.*;
import static Test.RomanCalcs.*;
import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(calc(input));
    }

    public static String calc(String input) throws Throwable {
        String result;
        String[] str = stringToNumbers(input);
        String action = whatAction(str[1]);

        if (isArabicNumber(str[0], str[2])) {
            Method method = ArabicCalcs.class.getDeclaredMethod(action, int.class, int.class);
            int res = (Integer) method.invoke(new ArabicCalcs(), new Object[] {parseInt(str[0]), parseInt(str[2])});
            result = ""+res;

        } else if (isRomanNumber(str[0], str[2])) {
            int arabic1 = romanToArabic(str[0]);
            int arabic2 = romanToArabic(str[2]);

            Method method = RomanCalcs.class.getDeclaredMethod(action, int.class, int.class);
            Integer invoke = (Integer) method.invoke(new RomanCalcs(), new Object[] {arabic1, arabic2});
            result = arabicToRoman(invoke);

        } else {
            throw new InvalidNumberFormat();
        }
        return result;
    }


    public static String[] stringToNumbers(String expression) throws InvalidNumberFormat {
        Pattern pattern = Pattern.compile("(.+?)\\s*([+\\-*/])\\s*(.+)");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            return new String[] {matcher.group(1), matcher.group(2),matcher.group(3)};
        } else {
            throw new InvalidNumberFormat();
        }
    }


    public static String whatAction(String sign) {
        String action = null;
        switch (sign) {
            case "+" -> action = "addition";
            case "-" -> action = "subtraction";
            case "*" -> action = "multiplication";
            case "/" -> action = "division";
        }
        return action;
    }


}
