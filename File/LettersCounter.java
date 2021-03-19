package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LettersCounter
{
    private int[] counter = new int[26];
    LettersCounter(Path path) throws Exception {
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    counter[c - 'a']++;
                } else if (c >= 'A' && c <= 'Z') {
                    counter[c - 'A']++;
                }
            }
        }
        scanner.close();
    }
    public int returnNumberOf(char arg) {
        if (arg >= 'a' && arg <= 'z') {
            return counter[arg - 'a'];
        } else if (arg >= 'A' && arg <= 'Z') {
            return counter[arg - 'A'];
        }
        return 0;
    }
}
