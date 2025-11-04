package com.javarush.poroshina.cryptoanalyzer.service;

import com.javarush.poroshina.cryptoanalyzer.util.FileManagerUtil;

import java.util.HashMap;

public class CaesarCipherService {

    private final char[] alphabet = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '\"', ':', '!', '?', '-', ' '};
    protected final HashMap<Character, Integer> alphabetPositions = new HashMap<Character, Integer>();
    private static CaesarCipherService instance;

    public CaesarCipherService() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabetPositions.put(alphabet[i], i);
        }
    }

    public static CaesarCipherService getInstance() {
        if (instance == null) {
            instance = new CaesarCipherService();
        }
        return instance;
    }

    public void encrypt(String text, int shift, boolean isEncryptOrDecrypt) {
        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            char currentChar = textArray[i];
            char lowerChar = Character.toLowerCase(currentChar);

            if (alphabetPositions.containsKey(lowerChar)) {
                int oldPosition = alphabetPositions.get(lowerChar);
                int newPosition;

                if (isEncryptOrDecrypt == true) {
                    newPosition = (oldPosition + shift) % alphabet.length;
                } else {
                    newPosition = (oldPosition - shift) % alphabet.length;
                }

                if (newPosition < 0) {
                    newPosition += alphabet.length;
                }
                char encryptedChar = alphabet[newPosition];
                textArray[i] = Character.isUpperCase(currentChar) ? Character.toUpperCase(encryptedChar) : encryptedChar;
            }
        }
        String encryptedOrDecryptedText = new String(textArray);
        FileManagerUtil.writeFile(encryptedOrDecryptedText);
    }

    public void findShift(String encryptedText) {
        for (int i = 0; i < alphabet.length; i++) {
            encrypt(encryptedText, i, false);
        }
    }
}
