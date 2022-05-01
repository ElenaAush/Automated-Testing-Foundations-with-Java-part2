package main.io.optionalTask;

import main.io.optionalTask.exception.SomeProblemsWithTheFile;

import java.io.*;

public class Task10 {
    
    public static void main(String[] args) {
    
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/BelieverSong.txt"));
             BufferedWriter bufferedWhiter = new BufferedWriter(new FileWriter(CreateFile.checkAndCreateFile("ChangeFirstAndLastWordsInSong.txt")))) {
        
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWhiter.write(changeFirstAndLast(line), 0, line.length());
                bufferedWhiter.append("\n");
            }
        } catch (SomeProblemsWithTheFile e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String changeFirstAndLast(String line) {
    
        String[] words = line.split(" ");
        StringBuilder string = new StringBuilder();
        
        if (words.length > 1) {
    
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
    
            for (String word : words) {
                string.append(word).append(" ");
            }
        } else {
            string = new StringBuilder(line);
        }
        
        return string.toString();
    }
}
