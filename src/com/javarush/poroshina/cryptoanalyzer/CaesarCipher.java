package com.javarush.poroshina.cryptoanalyzer;

import java.util.HashMap;

public class CaesarCipher {

    private final char[] alphabet;
    private final HashMap<Character, Integer> alphabetPositions;
    private static CaesarCipher instance;

    public CaesarCipher(char[] alphabet) {
        this.alphabet = alphabet;
        alphabetPositions = new HashMap<Character, Integer>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetPositions.put(alphabet[i], i);
        }
    }

    public static CaesarCipher getInstance() {
        if (instance == null) {
            instance = new CaesarCipher(new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к',
                    'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                    'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
                    '.', ',', '\"', ':', '!', '?', '-', ' '});
        }
        return instance;
    }

    public String encrypt(String text, int shift) {

        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            if (alphabetPositions.containsKey(textArray[i])) {
                int oldPosition = alphabetPositions.get(textArray[i]);
                int newPosition = (oldPosition + shift) % alphabet.length;

                if (newPosition < 0) {
                    newPosition += alphabet.length;
                }

                textArray[i] = alphabet[newPosition];
            }

        }
        String encryptedText = new String(textArray);
        return encryptedText;
    }

    public String decrypt(String encryptedText, int shift) {
        char[] textArray = encryptedText.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            if (alphabetPositions.containsKey(textArray[i])) {
                int oldPosition = alphabetPositions.get(textArray[i]);
                int newPosition = (oldPosition - shift) % alphabet.length;

                if (newPosition < 0) {
                    newPosition += alphabet.length;
                }

                textArray[i] = alphabet[newPosition];
            }

        }
        String decryptedText = new String(textArray);
        return decryptedText;
    }

}
