package main.io.optionalTask;

import main.io.optionalTask.exception.FileOrDirectoryException;

import java.io.*;

public class Task3 {
    
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/ProgramText.java"));
             BufferedWriter bufferedWhiter = new BufferedWriter(new FileWriter(FileCreator.createPath("ReverseProgramText.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWhiter.write(reverseString(line), 0, line.length());
                bufferedWhiter.append("\n");
            }
        } catch (FileOrDirectoryException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String reverseString(String line) {
        StringBuilder reverseLine = new StringBuilder();
        char[] chars = line.toCharArray();
        
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseLine.append(chars[i]);
        }
        
        return reverseLine.toString();
    }
}
