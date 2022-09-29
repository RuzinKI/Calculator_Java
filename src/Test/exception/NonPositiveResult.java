package Test.exception;

public class NonPositiveResult extends Throwable{

    public NonPositiveResult() {
        System.err.println("Неположительный результат");
    }
}
