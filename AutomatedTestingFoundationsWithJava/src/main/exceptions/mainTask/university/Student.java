package main.exceptions.mainTask.university;

import main.exceptions.mainTask.exception.LackOfSubjectForTheStudentException;

import java.util.List;

public class Student {
    
    private String nameStudent;
    private List<Subject> subjects;
    
    
    public Student(String nameStudent, List<Subject> subjects) throws LackOfSubjectForTheStudentException {
        if (subjects == null || subjects.isEmpty()) {
            throw new LackOfSubjectForTheStudentException("no one subject " + nameStudent + " student");
        }
        this.nameStudent = nameStudent;
        this.subjects = subjects;
    }
    
    public int averageScoreInAllSubjectsOfTheStudent() {

        int averageScore = 0;
        int countSubjects = 0;

        for (Subject subject : subjects) {
            averageScore += subject.getAssessment();
            countSubjects++;
        }

        averageScore /= countSubjects;

        return averageScore;
    }
    
    public String getNameStudent() {
        return nameStudent;
    }
    
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    
    public List<Subject> getSubjects() {
        return subjects;
    }
    
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    @Override
    public String toString() {
        return "\n-        Student{" +
                "nameStudent='" + nameStudent + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
