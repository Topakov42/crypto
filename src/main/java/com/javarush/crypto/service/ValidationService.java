package com.javarush.crypto.service;

import com.javarush.crypto.core.Alphabet;
import com.javarush.crypto.exception.CipherException;


public class ValidationService {
    public void validateTextForEncoding(String text) throws CipherException {

        if (text == null || text.trim().isEmpty()) {
            throw new CipherException("Текст не может быть пустым");
        }
        String upperText = text.toUpperCase();
        for (int i = 0; i < upperText.length(); i++) {
            char c = upperText.charAt(i);
            if (c == '\n') {
                continue;
            }
            if (!Alphabet.TEXT_TO_CIPHER.containsKey(c)) {
                throw new CipherException(String.format("Неподдерживаемый символ '%c' в позиции %d", c, (i + 1)));
            }
        }


    }

    public void validateCipherCode(String cipherCode) throws CipherException {
        // валидация кода
        if (cipherCode == null || cipherCode.trim().isEmpty()) {
            throw new CipherException("Шифр не может быть пустым");
        }

        String[] symbols = cipherCode.trim().split(" ");

        for (int i = 0; i < symbols.length; i++) {
            String symbol = symbols[i];

            if (!Alphabet.CIPHER_TO_TEXT.containsKey(symbol)) {
                throw new CipherException(String.format("Некорректный шифр '%s' в позиции '%d'", symbol, (i + 1)));
            }
        }
    }
}
