package com.javarush.crypto.service;

import com.javarush.crypto.exception.CipherException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {
    public String readFile(String filePath) throws CipherException {

        try {
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                throw new CipherException(String.format("Файла '%s'  не существует", filePath));
            }

            if (!Files.isReadable(path)) {
                throw new CipherException(String.format("Ошибка чтения файла ' %s' ", filePath));
            }

            if (Files.size(path) == 0) {
                throw new CipherException(String.format("Файл %s пустой", filePath));
            }
            return Files.readString(path);
        } catch (IOException e) {
            throw new CipherException("Ошибка чтения файла:  " + e.getMessage(), e);
        }
    }

    public void writeFail(String content, String filePath) throws CipherException {



        try {

            Path path = Path.of(filePath);
            Path parentDir = path.getParent();

            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            throw new CipherException("Ошибка записи файла: " + e.getMessage(), e);
        }


    }

    public boolean fileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}
