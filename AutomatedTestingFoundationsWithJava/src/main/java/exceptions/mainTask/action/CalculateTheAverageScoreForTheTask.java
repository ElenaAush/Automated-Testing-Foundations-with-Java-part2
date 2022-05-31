package exceptions.mainTask.action;

import exceptions.mainTask.model.FacultyType;
import exceptions.mainTask.model.SubjectType;

public interface CalculateTheAverageScoreForTheTask {
    
    int averageScoreInAllSubjectsOfTheStudentInUniversity(String nameStudent);
    
    int averageScoreOfSubjectInGroupAtFacultyInUniversity(FacultyType facultyType, String groupType, SubjectType subjectType);
    
    int averageScoreOfSubjectInUniversity(SubjectType subjectType);
}
