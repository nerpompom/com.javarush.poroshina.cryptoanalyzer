package com.javarush.poroshina.cryptoanalyzer.util;

import com.javarush.poroshina.cryptoanalyzer.constants.AppConstants;
import com.javarush.poroshina.cryptoanalyzer.service.CaesarCipherService;

import java.util.Scanner;

public class MenuUtil {

    private static MenuUtil instance;

    public static MenuUtil getInstance() {
        if (instance == null) {
            instance = new MenuUtil();
        }
        return instance;
    }

    public void start() {
        System.out.println(AppConstants.START_MESSAGE);

        info();
    }

    public void selector(Integer number) {
        switch (number) {
            case 0 -> info();
            //Путь шифровки файла
            case 1 -> CaesarCipherService.getInstance().encrypt(FileManagerUtil.getFile(), FileManagerUtil.getShift(), true);
            //Путь расшифровки файла
            case 2 -> CaesarCipherService.getInstance().encrypt(FileManagerUtil.getFile(), FileManagerUtil.getShift(), false);
            //Путь взлома файла
            case 3 -> CaesarCipherService.getInstance().findShift(FileManagerUtil.getFile());
            //Выход из программы
            case 4 -> exit();
        }
    }

    public void info() {
        System.out.println(AppConstants.INFO);

        workWithConsole();
    }

    public void workWithConsole() {
        System.out.println(AppConstants.ENTER_A_NUMBER);

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            Integer number = scanner.nextInt();

            switch (number) {
                case 0, 1, 2, 3, 4 -> selector(number);
                default -> workWithConsole();
            }

        } else {
            System.out.println(AppConstants.NOT_A_NUMBER_ERROR);
            workWithConsole();
        }
    }

    public void exit() {
        System.out.println(AppConstants.EXIT_MESSAGE);
        System.exit(0);
    }
}
