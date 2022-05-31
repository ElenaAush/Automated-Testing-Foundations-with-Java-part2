package io.mainTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        if (args[0] == null) {
            System.out.println("no path");
        }
        
        File file = new File(args[0]);
        
        if (file.isDirectory()) {
            getFilesInAllDirectory(file, 1);
            try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/main/resources/io/structureDirectory.txt"))) {
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
    }
    
    private static void getFilesInAllDirectory(File file, int level) {
        StringBuilder indent = new StringBuilder();
        StringBuilder indentDirectory = new StringBuilder();
        File[] inDirectory = file.listFiles();
        
        if (inDirectory == null) {
            return;
        }
        
        sortedFilesAndDirectory(inDirectory);
        
        addIndents(indent, indentDirectory, level);
        
        for (File one : inDirectory) {
            if (one.isFile()) {
                data.add(indent + one.getName());
            }
            if (one.isDirectory()) {
                data.add(indent.toString());
                data.add(indentDirectory + one.getName());
                getFilesInAllDirectory(one, level + 1);
            }
        }
    }
    
    private static void getDataAboutDirectoriesAndFiles() {
        int countDirectories = 0;
        int countFiles = 0;
        int averageCountOfFilesInADirectory = 0;
        int averageLengthOfFileNames = 0;
        Pattern pattern = Pattern.compile("[\\w\\.]+");
        
        for (String line : data) {
            Matcher matcher = pattern.matcher(line);
            
            if (isContainsDirectory(line)) {
                countDirectories++;
            } else if (matcher.find()) {
                countFiles++;
                averageLengthOfFileNames += getFileNameLength(matcher);
            }
        }
        
        if (isContainsDirectory(data.get(0))) {
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
    
    private static void sortedFilesAndDirectory(File[] inDirectory) {
        Arrays.sort(inDirectory, (o1, o2) -> {
            if (o1.isFile() && o2.isDirectory()) {
                return -1;
            }
            if (o2.isFile() && o1.isDirectory()) {
                return 1;
            }
            return 0;
        });
    }
    
    private static void addIndents(StringBuilder indent, StringBuilder indentDirectory, int level) {
        for (int i = 0; i < level; i++) {
            indentDirectory.append(indent).append("|---");
            indent.append("|   ");
        }
    }
    
    private static int getFileNameLength(Matcher matcher) {
        int startLinePosition = matcher.start();
        int endLinePosition = matcher.end();
        
        while (matcher.find()) {
            endLinePosition = matcher.end();
        }
        
        return endLinePosition - startLinePosition;
    }
    
    private static boolean isContainsDirectory(String line) {
        return line.contains("---");
    }
}
