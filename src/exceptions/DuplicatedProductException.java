package exceptions;

public class DuplicatedProductException extends Exception{
    public DuplicatedProductException() {
        super("The product already exists");
    }
}
