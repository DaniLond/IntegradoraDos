package exceptions;

public class NonexistentIndexException extends Exception{
    public NonexistentIndexException() {
        super("Index does not exist");
    }
}
