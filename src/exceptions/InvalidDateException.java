package exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String s) {
        super("you must put a consistent date");
    }
}

