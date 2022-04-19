package main.exceptions.mainTask.model;

import main.exceptions.mainTask.exception.AbsenceOfStudentsInTheGroupException;

import java.util.List;

public class Group {
    
    private String groupName;
    private List<Student> students;
    
    public Group(String groupName, List<Student> students) throws AbsenceOfStudentsInTheGroupException {
        if (students == null || students.isEmpty()) {
            throw new AbsenceOfStudentsInTheGroupException("no one students in " + groupName + " group");
        }
        this.groupName = groupName;
        this.students = students;
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    @Override
    public String toString() {
        return "\n-    Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}
