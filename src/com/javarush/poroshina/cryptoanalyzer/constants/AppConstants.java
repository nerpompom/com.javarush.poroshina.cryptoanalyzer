package com.javarush.poroshina.cryptoanalyzer.constants;

import java.util.HashMap;

public interface AppConstants {
    String START_MESSAGE = "Hello! Let's start";
    String EXIT_MESSAGE = "Program completed";
    String RECORD_FILE = "File recorded: ";

    String INFO = "0 - info\n1 - encrypt file\n2 - decrypt file\n3 - brute force\n4 - exit";
    String ENTER_A_NUMBER = "Enter a number between 0 and 4";
    String ENTER_THE_PATH = "Enter the path to the .txt file";
    String ENTER_A_SHIFT = "Enter a shift (number from 1 to 40)";

    String FILE = "file_";
    String TXT_FORMAT = ".txt";

    String NOT_A_NUMBER_ERROR = "This is not a number";
    String TXT_FORMAT_ERROR = "The file must be in .txt format";
    String OUT_OF_BOUNDS_ERROR = "The number is out of bounds";
    String FILE_NOT_FOUND_ERROR = "File not found";
    String READING_FILE_ERROR = "Error reading file";
    String WRITING_FILE_ERROR = "Writing file error";
    String CREATING_FOLDER_ERROR = "Creating folder error";

    //String MAIN_PATH = "./src/com/javarush/poroshina/cryptoanalyzer/files/";
}
