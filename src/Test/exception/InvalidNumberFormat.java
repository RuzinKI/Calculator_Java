package Test.exception;

public class InvalidNumberFormat extends Throwable {
    public InvalidNumberFormat() {
        System.err.println("Неверный формат чисел");
    }
}
