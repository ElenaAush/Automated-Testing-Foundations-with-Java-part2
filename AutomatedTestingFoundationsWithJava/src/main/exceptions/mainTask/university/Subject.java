package main.exceptions.mainTask.university;

import main.exceptions.mainTask.exception.IncorrectAssessmentException;
import main.exceptions.mainTask.model.SubjectType;

public class Subject {
    
    private SubjectType nameSubject;
    private int assessment;
    
    {
        assessment = 0;
    }
    
    public Subject(SubjectType nameSubject) {
        this.nameSubject = nameSubject;
    }
    
    public Subject(SubjectType nameSubject, int assessment) throws IncorrectAssessmentException {
        if (assessment < 0 || assessment > 10) {
            throw new IncorrectAssessmentException("wrong assessment " + assessment + " (" + nameSubject + ')');
        }
        this.nameSubject = nameSubject;
        this.assessment = assessment;
    }
    
    public SubjectType getNameSubject() {
        return nameSubject;
    }
    
    public void setNameSubject(SubjectType nameSubject) {
        this.nameSubject = nameSubject;
    }
    
    public int getAssessment() {
        return assessment;
    }
    
    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }
    
    @Override
    public String toString() {
        return "\n-            Subject{" +
                "nameSubject=" + nameSubject +
                ", assessment=" + assessment +
                "}";
    }
}
