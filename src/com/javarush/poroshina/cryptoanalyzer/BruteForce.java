package com.javarush.poroshina.cryptoanalyzer;

public class BruteForce extends Cipher {

    private static BruteForce instance;

    public BruteForce() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabetPositions.put(alphabet[i], i);
        }
    }

    public static BruteForce getInstance() {
        if (instance == null) {
            instance = new BruteForce();
        }
        return instance;
    }

    public void findShift(String encryptedText) {

        for (int i = 0; i < alphabet.length; i++) {
            decrypt(encryptedText, i);
            //System.out.println("Сдвиг: " + i + ", Расшифрованный текст: " + decryptedText);
        }
    }


    public void decrypt(String encryptedText, int shift) {
        char[] textArray = encryptedText.toCharArray();

        for (int i = 0; i < textArray.length; i++) {
            char currentChar = textArray[i];
            char lowerChar = Character.toLowerCase(currentChar);

            if (alphabetPositions.containsKey(lowerChar)) {
                int oldPosition = alphabetPositions.get(lowerChar);
                int newPosition = (oldPosition + shift) % alphabet.length;

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
