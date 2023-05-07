package exceptions;

public class NonexistentCategoryException extends Exception {
    public NonexistentCategoryException(){
        super("The category does not exist");
    }
}
