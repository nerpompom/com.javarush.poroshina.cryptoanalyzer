package com.javarush.poroshina.cryptoanalyzer;

public class Cipher {
    //34, 45, 49, 59, 60, 65, 78,

    private final char[] alphabet;
    private static Cipher instance;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public static Cipher getInstance() {
        if (instance == null) {
            instance = new Cipher(new char[] {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к',
                    'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                    'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
                    '.', ',', '\"', ':', '!', '?', '-', ' '});
        }
        return instance;
    }


    private char[] contains(char[] text) {

        for (int i = 0; i < text.length; i++) {
            for (char ch : alphabet) {
                if (ch == text[i]) {
                    text[i] = shift(positon(ch), 3);
                }
            }
        }
        return text;
    }

    private int positon(char ch) {
        for (int i = 0; i < alphabet.length; i++) {
            if (ch == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }


//    private char shiftEncrypt(int position, int shift) {
//        int newPosition = (position + shift) % alphabet.length;
//
//        return alphabet[newPosition];
//    }

    private char shift(int position, int shift) {

        int newPosition = (position + shift) % alphabet.length;

        if (newPosition < 0) {
            newPosition += alphabet.length;
        }

        return alphabet[newPosition];
    }




    public String encrypt(String text, int shift) {
        // Логика шифрования
        char[] textArray = text.toCharArray();


        String encryptText = new String(contains(textArray));


        return encryptText;
    }
    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        char[] textArray = encryptedText.toCharArray();

        contains(textArray);

        return "Расшифровываю";
    }
}
