package Test;

import Test.exception.NonPositiveResult;

import java.io.IOException;

public abstract class Calculations {

    public abstract int addition(int x, int y);

    public abstract int subtraction(int x, int y) throws NonPositiveResult;

    public abstract int multiplication(int x, int y);

    public abstract int division(int x, int y) throws NonPositiveResult, IOException;

}
