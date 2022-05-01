package main.io.mainTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    
    private static List<String> data = new ArrayList<>();
    
    public static void main(String[] args) {
        
        if (args[0] != null) {
            
            File file = new File(args[0]);
            
            if (file.isDirectory()) {
                
                getFilesInAllDirectory(file, 1);
                
                try (BufferedWriter buffer = new BufferedWriter(new FileWriter("out/data/structureDirectory.txt"))) {
                    for (String line : data) {
                        buffer.write(line, 0, line.length());
                        buffer.append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.isFile()) {
                
                try {
                    data = Files.readAllLines(Paths.get(args[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                getDataAboutDirectoriesAndFiles();
                
            } else {
                System.out.println("no valuable path");
            }
        } else {
            System.out.println("no path");
        }
    }
    
    private static void getFilesInAllDirectory(File file, int level) {
        
        StringBuilder indent = new StringBuilder();
        String indentFolder = "";
        File[] inFile = file.listFiles();
        
        if (inFile != null) {
            Arrays.sort(inFile, (o1, o2) -> {
                if (o1.isFile() && o2.isDirectory()) {
                    return -1;
                }
                if (o2.isFile() && o1.isDirectory()) {
                    return 1;
                }
                return 0;
            });
            
            for (int i = 0; i < level; i++) {
                indentFolder = indent + "|---";
                indent.append("|   ");
            }
            
            for (File one : inFile) {
                
                if (one.isFile()) {
                    data.add(indent + one.getName());
                }
                
                if (one.isDirectory()) {
                    data.add(indent.toString());
                    data.add(indentFolder + one.getName());
                    getFilesInAllDirectory(one, level + 1);
                }
            }
        }
    }
    
    private static void getDataAboutDirectoriesAndFiles() {
        
        int countDirectories = 0;
        int countFiles = 0;
        int averageCountOfFilesInADirectory = 0;
        int averageLengthOfFileNames = 0;
        
        for (String line : data) {
            
            Pattern pattern = Pattern.compile("[\\w\\.]+");
            Matcher matcher = pattern.matcher(line);
            
            if (line.contains("---")) {
                countDirectories++;
            } else if (matcher.find()) {
                countFiles++;
                averageLengthOfFileNames += getFileNameLength(matcher);
            }
        }
        
        if (data.get(0).contains("---")) {
            if (countDirectories != 0) {
                averageCountOfFilesInADirectory = countFiles / countDirectories;
            }
        } else {
            averageCountOfFilesInADirectory = countFiles / (countDirectories + 1);
        }
    
        averageLengthOfFileNames /= countFiles;
    
        System.out.println("Directories = " + countDirectories);
        System.out.println("Files = " + countFiles);
        System.out.println("Average files = " + averageCountOfFilesInADirectory);
        System.out.println("Average length of file names = " + averageLengthOfFileNames);
    }
    
    private static int getFileNameLength (Matcher matcher) {
        
        int startLinePosition = matcher.start();
        int endLinePosition = matcher.end();
        
        while (matcher.find()) {
            endLinePosition = matcher.end();
        }
        
        return endLinePosition - startLinePosition;
    }
}