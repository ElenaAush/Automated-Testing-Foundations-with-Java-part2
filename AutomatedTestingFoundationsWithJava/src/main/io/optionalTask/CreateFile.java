package main.io.optionalTask;

import main.io.optionalTask.exception.SomeProblemsWithTheFile;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    
    public static File checkAndCreateFile(String nameFile) throws SomeProblemsWithTheFile {
        
        File folder = new File("src/main/io/optionalTask/out");
        File file = new File(folder, nameFile);
        boolean createFolder;
        boolean createFile = false;
        
        if (!folder.exists()) {
            createFolder = folder.mkdir();
        } else {
            createFolder = true;
        }
        
        if (createFolder) {
            if (!file.exists()) {
                try {
                    createFile = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                createFile = true;
            }
        } else {
            throw new SomeProblemsWithTheFile("no exist folder");
        }
        
        if (createFile) {
            return file;
        } else {
            throw new SomeProblemsWithTheFile("no exist file");
        }
    }
}
