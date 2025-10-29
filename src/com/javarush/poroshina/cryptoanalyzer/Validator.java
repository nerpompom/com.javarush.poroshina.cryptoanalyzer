package com.javarush.poroshina.cryptoanalyzer;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator extends Cipher {

    protected static Path isValidPath(String filePath) {

        if (!filePath.endsWith(".txt")) {
            System.out.println("The file must be in .txt format");
            FileManager.getFile();
        }

        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            System.out.println("File not found");
            FileManager.getFile();
        }
        return path;
        }

        protected static int isValidShift(int shift) {

            if (shift < MIN_SHIFT || shift > MAX_SHIFT) {
                System.out.println("The number is out of bounds");
                FileManager.getShift();
            }

            return shift;
    }
}
