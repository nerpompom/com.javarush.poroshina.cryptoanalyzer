package com.javarush.poroshina.cryptoanalyzer;

public class App {
    public static void main(String[] args) {

        CaesarCipher caesarCipher = CaesarCipher.getInstance();
        BruteForce bruteForce = BruteForce.getInstance();


//        String s = caesarCipher.encrypt("абф5g", 8);
//        System.out.println(s);
//        String s1 = caesarCipher.decrypt("зиь5g", 8);
//        System.out.println(s1);
//        bruteForce.findShift("зиь5g");

        Menu menu = Menu.getInstance();

        menu.start();

        }
    }