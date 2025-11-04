package com.javarush.poroshina.cryptoanalyzer.util;


import com.javarush.poroshina.cryptoanalyzer.constants.AppConstants;
import com.javarush.poroshina.cryptoanalyzer.service.ValidatorService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManagerUtil {

    public static String getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(AppConstants.ENTER_THE_PATH);
        String filePath = scanner.nextLine();

        return readFile(ValidatorService.isValidPath(filePath));
    }

    public static int getShift() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(AppConstants.ENTER_A_SHIFT);

        if (!scanner.hasNextInt()) {
            System.out.println(AppConstants.NOT_A_NUMBER_ERROR);
            getShift();
        }
        int shift = scanner.nextInt();
        ValidatorService.isValidShift(shift);
        return shift;
    }

    public static String readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException(AppConstants.READING_FILE_ERROR);
        }
    }

    public static void writeFile(String text) {
        try {
            Path path = generateFileName();

            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write(text);
            }
            System.out.println(AppConstants.RECORD_FILE + path);
        } catch (IOException e) {
            throw new RuntimeException(AppConstants.WRITING_FILE_ERROR);
        }
    }

    private static Path generateFileName() throws IOException {
        int counter = 1;
        while (true) {
            String fileName = AppConstants.FILE + counter + AppConstants.TXT_FORMAT;
            Path currentFolder= Paths.get(".").toRealPath();
            Path path = currentFolder.resolve(fileName);
            //Path path = Paths.get(AppConstants.MAIN_PATH, fileName);
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
                throw new RuntimeException(AppConstants.CREATING_FOLDER_ERROR);
            }
        }
    }
}
