package main.io.optionalTask;

import main.io.optionalTask.exception.SomeProblemsWithTheFile;

import java.io.*;

public class Task7 {
    
    public static void main(String[] args) {
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/BelieverSong.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CreateFile.checkAndCreateFile("DeleteWordsInSong.txt")))) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = deleteWords(line);
                bufferedWriter.write(string, 0, string.length());
                bufferedWriter.append("\n");
            }
        } catch (SomeProblemsWithTheFile e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String deleteWords(String line) {
        
        String[] words = line.split(" ");
        StringBuilder string = new StringBuilder();
        
        if (words.length > 1) {
            
            int countWordsWith3To5 = 0;
            
            for (String word : words) {
                if (word.length() >= 3 && word.length() <= 5) {
                    countWordsWith3To5++;
                }
            }
            
            if (countWordsWith3To5 % 2 != 0) {
                countWordsWith3To5 -= 1;
            }
            
            for (String word : words) {
                if (countWordsWith3To5 != 0 && word.length() >= 3 && word.length() <= 5) {
                    countWordsWith3To5--;
                } else {
                    string.append(word).append(" ");
                }
            }
        } else {
            string = new StringBuilder(line);
        }
        
        return string.toString();
    }
}
