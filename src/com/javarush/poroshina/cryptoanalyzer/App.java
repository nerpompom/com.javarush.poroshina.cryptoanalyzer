package com.javarush.poroshina.cryptoanalyzer;

public class App {
    public static void main(String[] args) {

        Cipher cipher = Cipher.getInstance();

       // System.out.println(cipher.encrypt("абвгд", 4));

        Menu menu = Menu.getInstance();

        menu.start();

        }
    }