package io.optionalTask;

import io.optionalTask.exception.FileOrDirectoryException;

import java.io.*;

public class Task7 {
    private static final int MIN_LENGTH_WORD = 3;
    private static final int MAX_LENGTH_WORD = 5;
    
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/io/BelieverSong.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileCreator.createPath("DeleteWordsInSong.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = deleteWords(line);
                bufferedWriter.write(string, 0, string.length());
                bufferedWriter.append("\n");
            }
        } catch (FileOrDirectoryException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String deleteWords(String line) {
        StringBuilder string = new StringBuilder();
        String[] words = line.split(" ");
        int countWords = getAnEvenNumberOfWordsFrom3to5(words);
        
        if (words.length < 2) {
            return line;
        }
        
        for (String word : words) {
            if (countWords != 0 && word.length() >= MIN_LENGTH_WORD && word.length() <= MAX_LENGTH_WORD) {
                countWords--;
            } else {
                string.append(word).append(" ");
            }
        }
        
        return string.toString();
    }
    
    private static int getAnEvenNumberOfWordsFrom3to5(String[] words) {
        int countWords = 0;
    
        for (String word : words) {
            if (word.length() >= MIN_LENGTH_WORD && word.length() <= MAX_LENGTH_WORD) {
                countWords++;
            }
        }
    
        if (countWords % 2 != 0) {
            countWords -= 1;
        }
        
        return countWords;
    }
}
