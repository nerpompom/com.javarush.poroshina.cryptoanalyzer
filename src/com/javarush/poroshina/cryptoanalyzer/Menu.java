package com.javarush.poroshina.cryptoanalyzer;

import java.util.Scanner;

public class Menu {

    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void start() {
        System.out.println("Hello! Let's start");

        info();
    }

    public void selector(Integer number) {
        switch (number) {
            case 0 -> info();
            //Путь шифровки файла
            case 1 -> CaesarCipher.getInstance().encrypt(FileManager.getFile(), FileManager.getShift());
            //Путь расшифровки файла
            case 2 -> CaesarCipher.getInstance().decrypt(FileManager.getFile(), FileManager.getShift());
            //Путь взлома файла
            case 3 -> BruteForce.getInstance().findShift(FileManager.getFile());
            //Выход из программы
            case 4 -> exit();
        }
    }

    public void info(){

        System.out.println("0 - info\n1 - encrypt file\n2 - decrypt file\n3 - brute force\n4 - exit");

        workWithConsole();
    }

    public void workWithConsole () {
        System.out.println("Enter a number between 0 and 4");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            Integer number = scanner.nextInt();

            switch (number) {
                case 0, 1, 2, 3, 4 -> selector(number);
                default -> workWithConsole();
            }

        } else {
            System.out.println("This is not a number");
            workWithConsole();
        }
    }

    public void exit() {
        System.out.println("Program completed");
        System.exit(0);
    }

}
