package framework.exception;

public class NotFindElementInPageException extends RuntimeException{
    public NotFindElementInPageException(String message) {
        super(message);
    }
}
