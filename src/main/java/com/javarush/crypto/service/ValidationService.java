package com.javarush.crypto.service;

import com.javarush.crypto.exception.CipherException;

public class ValidationService {
    public void validateTextForEncoding (String text ) throws CipherException {
        // валидация текста для кодирования
        // проверить на нулл и пустоту
        // пройти по всем символам
        // проверить наличие в алфавите
        // выбросить исключение с инфо о позиции ошибки
    }
    public void validateCipherCode  (String cipherCode ) throws CipherException {
        // валидация кода
        // проверить на нулл и пустоту
        // разбить на отдельные коды
        // проверить каждый код
        // выбросить исключение с позиции ошибки
    }
 }
