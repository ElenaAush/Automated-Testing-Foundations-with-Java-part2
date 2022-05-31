package io.optionalTask;

import io.optionalTask.exception.FileOrDirectoryException;

import java.io.*;

public class Task10 {
    
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/io/BelieverSong.txt"));
             BufferedWriter bufferedWhiter = new BufferedWriter(new FileWriter(FileCreator.createPath("ChangeFirstAndLastWordsInSong.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWhiter.write(changeFirstAndLast(line), 0, line.length());
                bufferedWhiter.append("\n");
            }
        } catch (FileOrDirectoryException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String changeFirstAndLast(String line) {
        String[] words = line.split(" ");
        StringBuilder string = new StringBuilder();
        
        if (words.length < 2) {
            return line;
        }
        
        String temp = words[0];
        words[0] = words[words.length - 1];
        words[words.length - 1] = temp;
        
        for (String word : words) {
            string.append(word).append(" ");
        }
        
        return string.toString();
    }
}
