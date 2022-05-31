package exceptions.mainTask;

import exceptions.mainTask.exception.*;
import exceptions.mainTask.model.*;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    
    private static University university;
    
    public static void main(String[] args) {
    
        FacultyType facultyType = FacultyType.HISTORICAL;
        String group = "3";
        SubjectType subjectType = SubjectType.ART_HISTORY;
        String student = "Sasha";
        
        if (addData()) {
            
            System.out.println(university);
            System.out.println();
            System.out.println("Average score " + student + " = " + university.averageScoreInAllSubjectsOfTheStudentInUniversity(student));
            System.out.println("Average score in " + facultyType + " in " + group + " " + subjectType + " in university = "
                    + university.averageScoreOfSubjectInGroupAtFacultyInUniversity(facultyType, group, subjectType));
            System.out.println("Average score " + subjectType + " in university = " + university.averageScoreOfSubjectInUniversity(subjectType));
        }
    }
    
    private static boolean addData() {
        
        List<Subject> subjectsBiologicalWell;
        List<Subject> subjectsBiologicalBad;
        List<Subject> subjectsChemicalWell;
        List<Subject> subjectsHistoricalPerfect;
        List<Subject> subjectsHistoricalWell;
        List<Subject> subjectsHistoricalBad;
        List<Student> studentsForGroup1 = new ArrayList<>();
        List<Student> studentsForGroup2 = new ArrayList<>();
        List<Student> studentsForGroup3 = new ArrayList<>();
        List<Student> studentsForGroup4 = new ArrayList<>();
        List<Group> groupsForBiological = new ArrayList<>();
        List<Group> groupsForChemical = new ArrayList<>();
        List<Group> groupsForHistorical = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();
        
        try {
            subjectsBiologicalWell = addSubjects(FacultyType.BIOLOGICAL, "well");
            subjectsBiologicalBad = addSubjects(FacultyType.BIOLOGICAL, "bad");
            subjectsChemicalWell = addSubjects(FacultyType.CHEMICAL, "well");
            subjectsHistoricalPerfect = addSubjects(FacultyType.HISTORICAL, "perfect");
            subjectsHistoricalWell = addSubjects(FacultyType.HISTORICAL, "well");
            subjectsHistoricalBad = addSubjects(FacultyType.HISTORICAL, "bad");
            studentsForGroup1.add(new Student("Ann", subjectsBiologicalWell));
            studentsForGroup1.add(new Student("Mary", subjectsBiologicalBad));
            studentsForGroup2.add(new Student("Yan", subjectsChemicalWell));
            studentsForGroup3.add(new Student("Denis", subjectsHistoricalPerfect));
            studentsForGroup3.add(new Student("Vlad", subjectsHistoricalBad));
            studentsForGroup3.add(new Student("Mark", subjectsHistoricalWell));
            studentsForGroup4.add(new Student("Liza", subjectsHistoricalWell));
            studentsForGroup4.add(new Student("Sasha", subjectsHistoricalBad));
            groupsForBiological.add(new Group("1", studentsForGroup1));
            groupsForChemical.add(new Group("2", studentsForGroup2));
            groupsForHistorical.add(new Group("3", studentsForGroup3));
            groupsForHistorical.add(new Group("4", studentsForGroup4));
            faculties.add(new Faculty(FacultyType.BIOLOGICAL, groupsForBiological));
            faculties.add(new Faculty(FacultyType.CHEMICAL, groupsForChemical));
            faculties.add(new Faculty(FacultyType.HISTORICAL, groupsForHistorical));
            university = new University(faculties);
        } catch (LackOfSubjectForTheStudentException | AbsenceOfStudentsInTheGroupException | AbsenceOfGroupsAtTheFacultyException | LackOfFacultiesAtTheUniversityException | IncorrectAssessmentException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static List<Subject> addSubjects(FacultyType facultyType, String string) throws IncorrectAssessmentException {
        
        List<Subject> subjects = new ArrayList<>();
        SubjectType[] subjectTypes = SubjectType.values();
        int assessmentFrom;
        
        switch (string) {
            case "perfect":
                assessmentFrom = 8;
                break;
            case "well":
                assessmentFrom = 6;
                break;
            case "bad":
                assessmentFrom = 3;
                break;
            default:
                assessmentFrom = -1;
        }
    
        for (SubjectType subjectType : subjectTypes) {
            int assessment = assessmentFrom + (int) (Math.random() * (10 - assessmentFrom));
            if (subjectType.getNameFaculty() == facultyType) {
                subjects.add(new Subject(subjectType, assessment));
            }
        }
        
        return subjects;
    }
}
