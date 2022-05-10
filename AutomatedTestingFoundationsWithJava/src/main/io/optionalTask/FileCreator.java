package main.io.optionalTask;

import main.io.optionalTask.exception.FileOrDirectoryException;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    
    public static File createPath(String nameFile) throws FileOrDirectoryException {
        File folder = new File("src/main/io/optionalTask/out");
        File file = new File(folder, nameFile);
        boolean isFolderCreated;
        boolean isFileCreated = false;
        
        if (!folder.exists()) {
            isFolderCreated = folder.mkdir();
        } else {
            isFolderCreated = true;
        }
        
        if (isFolderCreated) {
            if (!file.exists()) {
                try {
                    isFileCreated = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                isFileCreated = true;
            }
        } else {
            throw new FileOrDirectoryException("no exist folder");
        }
        
        if (isFileCreated) {
            return file;
        } else {
            throw new FileOrDirectoryException("no exist file");
        }
    }
}
