package exceptions.mainTask.exception;

public class LackOfSubjectForTheStudentException extends Exception {
    
    public LackOfSubjectForTheStudentException() {
    }
    
    public LackOfSubjectForTheStudentException(String message) {
        super(message);
    }
}
