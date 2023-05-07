package exceptions;

public class EmptyListException extends Exception{
    public EmptyListException() {
        super("Empty list");
    }
}
