package main.io.optionalTask.exception;

public class FileOrDirectoryException extends Exception {
    public FileOrDirectoryException(String message) {
        super(message);
    }
    
    public FileOrDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
