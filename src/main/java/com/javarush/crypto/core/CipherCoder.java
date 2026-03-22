package com.javarush.crypto.core;

import com.javarush.crypto.exception.CipherException;
import com.javarush.crypto.model.ProcessingResult;
import com.javarush.crypto.service.ValidationService;

public class CipherCoder {

    private final ValidationService validationService;

    public CipherCoder(ValidationService validationService) {
        this.validationService = validationService;
    }

    public ProcessingResult encodeText(String text, int key) throws CipherException {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char currentChar = Character.toUpperCase(text.charAt(i));

            if (currentChar == '\n') {
                stringBuilder.append(currentChar);
                continue;
            }

            if (!Alphabet.TEXT_TO_CIPHER.containsKey(currentChar)) {
                continue;
            }

            int pos = posSymbol(key, currentChar);

            stringBuilder.append(Alphabet.CIPHER_TO_TEXT.get(String.valueOf(pos)));
        }

        String encode = stringBuilder.toString();
        return new ProcessingResult(true, "Текст успешно закодирован", getPreview(text), getPreview(encode));
    }


    public int posSymbol(int key, char currentChar) {
        String posStr = Alphabet.TEXT_TO_CIPHER.get(currentChar);
        int position = Integer.parseInt(posStr);
        int alphabetSize = Alphabet.TEXT_TO_CIPHER.size();

        // Корректный циклический сдвиг для положительных и отрицательных ключей
        int newPos = (position + key) % alphabetSize;
        if (newPos < 0) {
            newPos += alphabetSize; // обработка отрицательных сдвигов
        }
        return newPos;
    }

    public String getPreview(String text) {
        if (text.length() <= 100) {
            return text;
        }
        return text.substring(0, 97) + " ... ";
    }
}