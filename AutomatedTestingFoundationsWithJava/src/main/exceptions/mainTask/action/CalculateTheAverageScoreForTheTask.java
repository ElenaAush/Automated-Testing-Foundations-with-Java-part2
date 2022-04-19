package main.exceptions.mainTask.action;

import main.exceptions.mainTask.model.FacultyType;
import main.exceptions.mainTask.model.SubjectType;

public interface CalculateTheAverageScoreForTheTask {
    
    int averageScoreInAllSubjectsOfTheStudentInUniversity(String nameStudent);
    
    int averageScoreOfSubjectInGroupAtFacultyInUniversity(FacultyType facultyType, String groupType, SubjectType subjectType);
    
    int averageScoreOfSubjectInUniversity(SubjectType subjectType);
}
