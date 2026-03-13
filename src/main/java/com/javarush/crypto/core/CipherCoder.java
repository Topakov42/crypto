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

    public ProcessingResult encodeText(String text) throws CipherException {
        // коидрование в шифр
        // 1 валидация входного текста
        // 2 привести к регистру
        // 3 пройтись по всем символам
        // 4 найти код цезаря для каждого символа
        // 5 собрать результат с пробелами
        // 6 вернуть proccesingResult
        return null;

    }

    public ProcessingResult decodeText(String cipherCode) throws CipherException {
        // декодирование шифра в текст
        // 1 валидация входного шрифра
        // 2 разбить на отдельные символы
        // 3 найти букву для каждого слова
        // 4 обрабоать разделитеть слов
        // 5 собрать результат
        // 6 вернуть proccesingResult
        return null;
    }
public String getPreview (String  text) {
        // создание превью текста
    // 1 если текст короткий - вернуть как есть
    // 2  если длинный - обрезать и добавить ".."
    return null;

}

}