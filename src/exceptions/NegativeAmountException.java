package exceptions;

public class NegativeAmountException extends Exception{
    public NegativeAmountException(String s){
        super("Negative amount deteted");
    }
}
