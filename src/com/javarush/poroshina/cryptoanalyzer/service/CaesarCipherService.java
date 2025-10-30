package com.javarush.poroshina.cryptoanalyzer.service;

import com.javarush.poroshina.cryptoanalyzer.util.FileManagerUtil;

public class CaesarCipherService extends CipherService {

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
