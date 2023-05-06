package exceptions;

public class NegativeAmountException extends Exception{
    public NegativeAmountException(){
        super("Negative amount deteted");
    }
}
