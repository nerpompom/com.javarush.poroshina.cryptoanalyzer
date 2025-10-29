package com.javarush.poroshina.cryptoanalyzer;


public class CaesarCipher extends Cipher {

    private static CaesarCipher instance;

    public CaesarCipher() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabetPositions.put(alphabet[i], i);
        }
    }

    public static CaesarCipher getInstance() {
        if (instance == null) {
            instance = new CaesarCipher();
        }
        return instance;
    }

    public void encrypt(String text, int shift) {

        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            char currentChar = textArray[i];
            char lowerChar = Character.toLowerCase(currentChar);

            if (alphabetPositions.containsKey(lowerChar)) {
                int oldPosition = alphabetPositions.get(lowerChar);
                int newPosition = (oldPosition + shift) % alphabet.length;

                if (newPosition < 0) {
                    newPosition += alphabet.length;
                }

                char encryptedChar = alphabet[newPosition];
                textArray[i] = Character.isUpperCase(currentChar) ? Character.toUpperCase(encryptedChar) : encryptedChar;
            }
        }

        String encryptedText = new String(textArray);
        FileManager.writeFile(encryptedText);
    }

    public void decrypt(String encryptedText, int shift) {
        char[] textArray = encryptedText.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            char currentChar = textArray[i];
            char lowerChar = Character.toLowerCase(currentChar);

            if (alphabetPositions.containsKey(lowerChar)) {
                int oldPosition = alphabetPositions.get(lowerChar);
                int newPosition = (oldPosition - shift) % alphabet.length;

                if (newPosition < 0) {
                    newPosition += alphabet.length;
                }

                char decryptedChar = alphabet[newPosition];
                textArray[i] = Character.isUpperCase(currentChar) ? Character.toUpperCase(decryptedChar) : decryptedChar;
            }
        }

        String decryptedText = new String(textArray);
        FileManager.writeFile(decryptedText);
    }

}
