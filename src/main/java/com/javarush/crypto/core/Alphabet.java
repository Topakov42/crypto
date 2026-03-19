package com.javarush.crypto.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    public static final Map<Character, String> TEXT_TO_CIPHER;
    public static final Map<String, Character> CIPHER_TO_TEXT;
    private static int alphabetSize = 0;
    private static char[] symbols = {' ', '.', ',', '!', ':', ';', '?', '-', '—', '(', ')', '"', '\''};


    static {
        Map<Character, String> textToCipher = new HashMap<>();
        Map<String, Character> cipherToText = new HashMap<>();

        for (char i = 'А'; i <= 'Я'; i++) {


            if (alphabetSize == 6) {
                i--;
                textToCipher.put('Ё', String.valueOf(alphabetSize));
                alphabetSize++;
                continue;
            }


            textToCipher.put(i, String.valueOf(alphabetSize));
            alphabetSize++;
        }

        for (int i = 0; i < symbols.length; i++) {
            textToCipher.put(symbols[i], String.valueOf(alphabetSize));
            alphabetSize++;
        }


        for (var reverse : textToCipher.entrySet()) {
            cipherToText.put(reverse.getValue(), reverse.getKey());
        }

        TEXT_TO_CIPHER = Collections.unmodifiableMap(textToCipher);
        CIPHER_TO_TEXT = Collections.unmodifiableMap(cipherToText);
    }

    private Alphabet() {
        // запрет создания
    }

}
