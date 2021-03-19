package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.*;

public class Main 
{
    public static void main(String[] args) throws Exception {
        System.out.print("Enter the input filename: ");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        scan.close();
        Path path = Paths.get(filepath);
        if (Files.exists(path)) {
            LettersCounter example = new LettersCounter(path);
            FileWriter output = new FileWriter("output.txt");
            for (int i = 0; i < 26; i++) {
                char initial = (char)('a'+i);
                output.write(initial + ": " + example.returnNumberOf(initial) + "\n");
            }
            output.close();
        } else {
            System.out.print("Wrong directory");
        }
    }
}