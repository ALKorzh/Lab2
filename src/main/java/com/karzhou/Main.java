package com.karzhou;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.parser.FractionParser;
import com.karzhou.fraction.reader.FractionFileReader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FractionFileReader fileReader = new FractionFileReader();
        FractionParser parser = new FractionParser();

        List<Fraction> fractions = new ArrayList<>();
        try {
            List<String> lines = fileReader.readLines("fractions.txt");
            for (String line : lines) {
                try {
                    Fraction fraction = parser.parse(line);
                    fractions.add(fraction);
                } catch (InvalidFractionException e) {
                    System.err.println("Failed to parse fraction: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }
    }
}
