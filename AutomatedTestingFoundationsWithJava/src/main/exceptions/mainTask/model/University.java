package main.exceptions.mainTask.model;

import main.exceptions.mainTask.action.CalculateTheAverageScoreForTheTask;
import main.exceptions.mainTask.exception.LackOfFacultiesAtTheUniversityException;

import java.util.List;

public class University implements CalculateTheAverageScoreForTheTask {
    
    private List<Faculty> faculties;
    
    public University(List<Faculty> faculties) throws LackOfFacultiesAtTheUniversityException {
        if (faculties == null || faculties.isEmpty()) {
            throw new LackOfFacultiesAtTheUniversityException("no one faculty in university");
        }
        this.faculties = faculties;
    }
    
    public List<Faculty> getFaculties() {
        return faculties;
    }
    
    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
    
    @Override
    public int averageScoreInAllSubjectsOfTheStudentInUniversity(String studentName) {
    
        for (Faculty faculty : faculties) {
            List<Group> groups = faculty.getGroups();
            for (Group group : groups) {
                List<Student> students = group.getStudents();
                for (Student student : students) {
                    if (student.getNameStudent().equals(studentName)) {
                        return student.averageScoreInAllSubjectsOfTheStudent();
                    }
                }
            }
        }
        
        return -1;
    }
    
    @Override
    public int averageScoreOfSubjectInGroupAtFacultyInUniversity(FacultyType facultyType, String groupType, SubjectType subjectType) {
    
        int averageScore = 0;
        int countSubjects = 0;
    
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equals(facultyType)) {
                List<Group> groups = faculty.getGroups();
    
                for (Group group : groups) {
                    if (group.getGroupName().equals(groupType)) {
                        List<Student> students = group.getStudents();
    
                        for (Student student : students) {
                            List<Subject> subjects = student.getSubjects();
                            for (Subject subject : subjects) {
                                if (subject.getNameSubject().equals(subjectType)) {
                                    averageScore += subject.getAssessment();
                                    countSubjects++;
                                }
                            }
                        }
                    }
                }
            }
        }
    
        if (countSubjects > 0) {
            return averageScore /= countSubjects;
        } else {
            return -1;
        }
    }
    
    @Override
    public int averageScoreOfSubjectInUniversity(SubjectType subjectType) {
    
        int averageScore = 0;
        int countSubjects = 0;
    
        for (Faculty faculty : faculties) {
            List<Group> groups = faculty.getGroups();
            for (Group group : groups) {
                List<Student> students = group.getStudents();
                for (Student student : students) {
                    List<Subject> subjects = student.getSubjects();
                    for (Subject subject : subjects) {
                        if (subject.getNameSubject().equals(subjectType)) {
                            averageScore += subject.getAssessment();
                            countSubjects++;
                        }
                    }
                }
            }
        }
        
        if (countSubjects > 0) {
            return averageScore / countSubjects;
        } else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "University{" + faculties + '}';
    }
}
