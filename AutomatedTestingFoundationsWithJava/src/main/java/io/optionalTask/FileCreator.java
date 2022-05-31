package io.optionalTask;

import io.optionalTask.exception.FileOrDirectoryException;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    
    public static File createPath(String nameFile) throws FileOrDirectoryException {
        File folder = new File("src/main/resources/io/optionalTask");
        File file = new File(folder, nameFile);
        boolean isFolderCreated;
        boolean isFileCreated = false;
        
        if (!folder.exists()) {
            isFolderCreated = folder.mkdir();
        } else {
            isFolderCreated = true;
        }
        
        if (!isFolderCreated) {
            throw new FileOrDirectoryException("no exist folder");
        }
        
        if (!file.exists()) {
            try {
                isFileCreated = file.createNewFile();
            } catch (IOException e) {
                throw new FileOrDirectoryException("no created file", e);
            }
        } else {
            isFileCreated = true;
        }
        
        if (!isFileCreated) {
            throw new FileOrDirectoryException("no exist file");
        }
        
        return file;
    }
}
