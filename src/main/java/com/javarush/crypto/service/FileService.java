package com.javarush.crypto.service;

import com.javarush.crypto.exception.CipherException;

import javax.annotation.processing.FilerException;

public class FileService {
    public String readFile(String filePath) throws CipherException {
// чтение файла с валидацией
        // 1 преобразовать путь в PAth
        // 2 проверить существование файла
        // 3 проверить права на чтение
        // 4 проверить содержимое
        // 5 обработать IOExp
        return null;

    }

    public void writeFail (String content, String filePath ) throws CipherException  {
        // запись файла с созданием директории
        // 1 преобразовать путь
        // 2 создать род директории
        // 3 записать содержимое опциями
        // 4 обработать IoExpc

    }

    public boolean fileExists (String filePath ) {
        // проверка существования файла
        return false;
    }
}
