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

    //Метод, с которого начинается работа с программой
    public void start() {
        System.out.println("Hello! Let's start");
        info();
    }

    //Метод для выбора режима работы
    public void selector(Integer number) {
        switch (number) {
            //Вызов справки
            case 0 -> info();
            //Путь расшифровки файла
            case 1 -> System.out.println("ENCRYPT FILE");
            //Путь шифровки файла
            case 2 -> System.out.println("DECRYPT FILE");
            //Путь взлома файла
            case 3 -> System.out.println("BRUTE FORCE");
            //Выход из программы
            case 4 -> exit();
        }
    }

    public void info(){

        System.out.println("0 - info\n1 - encrypt file\n2 - decrypt file\n3 - brute force\n4 - exit");

        workWithConsole();
    }

    public void workWithConsole () {
        System.out.println("Введите число от 0 до 4");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            Integer number = scanner.nextInt();

            switch (number) {
                case 0, 1, 2, 3, 4 -> selector(number);
                default -> workWithConsole();
            }

        } else {
            System.out.println("Это не число");
            workWithConsole();
        }
    }

    public void exit() {
        System.out.println("Program completed");
        System.exit(0);
    }

}
