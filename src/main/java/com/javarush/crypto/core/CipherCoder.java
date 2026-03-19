package com.javarush.crypto.core;

import com.javarush.crypto.exception.CipherException;
import com.javarush.crypto.model.ProcessingResult;
import com.javarush.crypto.service.ValidationService;

public class CipherCoder {

    private final ValidationService validationService;

    public CipherCoder(ValidationService validationService) {
        // инициализирование  valid service
        this.validationService = validationService;
    }

    public ProcessingResult encodeText(String text, int key) throws CipherException {
        // коидрование в шифр


        // 1 валидация входного текста
        validationService.validateTextForEncoding(text);
//        String upperText = text.toUpperCase();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < upperText.length(); i++) {
//            char currentChar = upperText.charAt(i);
//            stringBuilder.append(String.valueOf(Integer.parseInt(Alphabet.TEXT_TO_CIPHER.get(currentChar))+key));
//            if (i < upperText.length() - 1) {
//                stringBuilder.append(" ");
//            }
//        }



        // 2 перебираем все символы
        // 2.1 приводим каждый симвл к регистру
        // 2.1.1 если буква на входе была в нижнем регистре, то в "хранилище" она попадает в нижнем регистре, если в верхнем то наоборот.

        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < text.length() ; i++) {

            char currentChar = text.charAt(i);




        }


        String encode = stringBuilder.toString();


        return new ProcessingResult(true, "Текст успешно закодирован", getPreview(text), getPreview(encode));
        // 4 найти код цезаря для каждого символа
        // 5 собрать результат с пробелами
        // 6 вернуть


        // Получается у нас он вернул цифры
    }

    public ProcessingResult decodeText(String cipherCode) throws CipherException {
        // декодирование шифра в текст
        // 1 валидация входного шифра
        validationService.validateCipherCode(cipherCode);
        StringBuilder result = new StringBuilder();
        String[] numbers = cipherCode.trim().split(" ");


        // 2 разбить на отдельные символы
        // 3 найти букву для каждого слова
        for (String number : numbers) {
            if (Alphabet.CIPHER_TO_TEXT.containsKey(number)) {
                result.append(Alphabet.TEXT_TO_CIPHER.get(number));
            } else if (number.equals(" ")) {
                result.append(" ");
            }
        }


        // 4 обрабоать разделитеть слов
        // 5 собрать результат

        String decoded = result.toString();
        return new ProcessingResult(true, " Код успешно декодирован", getPreview(cipherCode), getPreview(decoded));
        // 6 вернуть
    }

    public String getPreview(String text) {
        if (text.length() <= 100) {
            return text;
        }
        return text.substring(0, 97) + " ... ";

    }
}