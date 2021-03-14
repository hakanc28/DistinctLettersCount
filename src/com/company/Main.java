package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{
            List<String> allLines = Files.readAllLines(Paths.get(args[0].toString())); // reading all lines from the text file.

            DistinctCountLetters distinctCountLetters = new DistinctCountLetters();

            for (String line : allLines) { // calculating minimum number of letters that must be deleted for all lines
                distinctCountLetters.setStr(line);
                distinctCountLetters.calculate();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
