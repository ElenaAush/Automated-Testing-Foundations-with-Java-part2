package main.exceptions.mainTask.university;

import main.exceptions.mainTask.exception.AbsenceOfGroupsAtTheFacultyException;
import main.exceptions.mainTask.model.FacultyType;

import java.util.List;

public class Faculty {
    
    private FacultyType facultyName;
    private List<Group> groups;
    
    public Faculty(FacultyType facultyName, List<Group> groups) throws AbsenceOfGroupsAtTheFacultyException {
        if (groups == null || groups.isEmpty()) {
            throw new AbsenceOfGroupsAtTheFacultyException("no one group in " + facultyName + " faculty");
        }
        this.facultyName = facultyName;
        this.groups = groups;
    }
    
    public FacultyType getFacultyName() {
        return facultyName;
    }
    
    public void setFacultyName(FacultyType facultyName) {
        this.facultyName = facultyName;
    }
    
    public List<Group> getGroups() {
        return groups;
    }
    
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    @Override
    public String toString() {
        return "\n-Faculty{" +
                "facultyName=" + facultyName +
                ", groups=" + groups +
                '}';
    }
}