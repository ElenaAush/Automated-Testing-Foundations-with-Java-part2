package main.exceptions.mainTask.model;

import static main.exceptions.mainTask.model.FacultyType.*;

public enum SubjectType {
    
    SELECTION_OF_MICROORGANISMS_AND_PLANTS(BIOLOGICAL),
    BIOCHEMICAL_ANALYSIS_AND_BIOEQUIVALENCE(BIOLOGICAL),
    XENOBIOTICS_AND_BIOSECURITY(BIOLOGICAL),
    CHEMICAL_SCIENCE(CHEMICAL),
    ART_HISTORY(HISTORICAL),
    ETHNOLOGY(HISTORICAL),
    CULTURAL_STUDIES(HISTORICAL),
    ARCHEOLOGY(HISTORICAL),
    AIR_DEFENSE(MILITARY),
    RADIATION_CHEMICAL_AND_BIOLOGICAL_PROTECTION(MILITARY);
    
    private FacultyType nameFaculty;
    
    SubjectType(FacultyType nameFaculty) {
        this.nameFaculty = nameFaculty;
    }
    
    public FacultyType getNameFaculty() {
        return nameFaculty;
    }
}
