package com.javarush.poroshina.cryptoanalyzer;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    private static final String MAIN_PATH = "./src/com/javarush/poroshina/cryptoanalyzer/files/";

    public static String getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the .txt file");
        String filePath = scanner.nextLine();

        return readFile(Validator.isValidPath(filePath));
    }

    public static int getShift() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a shift (number from 0 to 40)");

        if (!scanner.hasNextInt()) {
            System.out.println("This is not a number");
            getShift();
        }

        int shift = scanner.nextInt();
        Validator.isValidShift(shift);
        return shift;
    }

    public static String readFile(Path path) {
        //Может переделать на чтение байт, а потом преобразование в строку?
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }

    }

    public static void writeFile(String text) {
        try {
            Path path = generateFileName();

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write(text);
            }
            System.out.println("File recorded: " + path);
        } catch (IOException e) {
            throw new RuntimeException("Writing file error");
        }
    }

    private static Path generateFileName() {
        int counter = 1;
        while (true) {
            String fileName = "file_" + counter + ".txt";
            Path path = Paths.get(MAIN_PATH, fileName);
            isDirectoryExist(path.getParent());
            if (!Files.exists(path)) {
                return path;
            }
            counter++;
        }
    }

    private static void isDirectoryExist(Path folder) {
        if (!Files.exists(folder)) {
            try {
                Files.createDirectories(folder);
            } catch (IOException e) {
                throw new RuntimeException("Creating folder error");
            }
        }
    }


}
