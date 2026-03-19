package com.javarush.crypto;


import com.javarush.crypto.core.Alphabet;
import com.javarush.crypto.core.CipherCoder;
import com.javarush.crypto.exception.CipherException;
import com.javarush.crypto.model.ProcessingResult;
import com.javarush.crypto.service.FileService;
import com.javarush.crypto.service.ValidationService;

import java.util.*;


public class CryptoApp {

    private final CipherCoder cipherCoder;
    private final FileService fileService;
    private final Scanner scanner;

    public CryptoApp(CipherCoder cipherCoder, FileService fileService, Scanner scanner) {
        this.cipherCoder = cipherCoder;
        this.fileService = fileService;
        this.scanner = scanner;
    }

    static void main(String[] args) {
        CryptoApp cryptoApp = new CryptoApp(
                new CipherCoder(new ValidationService()),
                new FileService(),
                new Scanner(System.in)
        );
        cryptoApp.run();
    }

    public void run() {
        //1 приветсвие
        printWelcomeMessage();
        // 2 меню (цикл бесконечный
        boolean exit = true;
        while (exit) {
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processEncodeFile();
                    break;

                case "2":
                    processDecodeFile();
                    break;

                case "3":
                    showAlphabetInfo();
                    break;

                case "0":
                    System.out.println("Bye bye");
                    exit = false;
                    break;
                default:
                    System.out.println("Попробуйте снова");
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Добро пожаловать в программу CipherApp");
        System.out.println("_".repeat(20));
    }

    private void showMainMenu() {
        // отобразить меню с вариантами действий
        System.out.println("МЕНЮ");
        System.out.println("1 - Кодирование файла ");
        System.out.println("2 - Декодирование файла");
        System.out.println("3 - Показать алфавит");
        System.out.println("0 - Выход из программы");
        System.out.println("Выберите действие  : ");
    }

    private void processEncodeFile() {
        //обработка кодирования файла
        try {
            int key = keyValue();
            String fileInput = getInputFilePath();
            String context = fileService.readFile(fileInput);
            String fileOutput = getOutputFilePath();
            ProcessingResult result = cipherCoder.encodeText(context, key);
            fileService.writeFail(getOutputFromResult(result), fileOutput);

            displaySucessResult(result, fileInput, fileOutput);
        } catch (CipherException e) {
            displayError(e.getMessage());
        }

    }


    private void processDecodeFile() {
        //обработка декодирования
        // 1 получить пути
        // 2 прочитать файл
        // 3  декодировать морзе
        //4 показать результат
    }


    private String getInputFilePath() {
        System.out.print("Введите название файла:  ");
        String fileName = scanner.nextLine();
        return fileName;
    }

    private int keyValue() {
        System.out.println("Введите значение ключа");
        int key = scanner.nextInt();

        if (Math.abs(key) > Math.abs(Alphabet.CIPHER_TO_TEXT.size())) {
            System.out.format("Значение ключа не может быть больше значения алфавита - %s\n", Alphabet.TEXT_TO_CIPHER.size());
            keyValue();
        }
        scanner.nextLine();
        System.out.println("Сдвиг на " + key);
        return key;
    }

    private String getOutputFilePath() {

        System.out.println("Введите название зашифрованного  файла: ");
        String fileName = scanner.nextLine();
        return fileName;

    }

    private void displaySucessResult(ProcessingResult result, String fileInput, String fileOutput) {
        // красивый вывод успех резульатта
        System.out.println(result.getMessage());
        System.out.println("Закодировали - " + fileInput);
        System.out.println("Получили  - " + fileOutput);


    }

    private void displayError(String message) {
        System.out.println(message);

    }


    private void showAlphabetInfo() {
        for (int i = 0; i <= Alphabet.CIPHER_TO_TEXT.size(); i++) {
            System.out.format(" Ключ к символу - %s , Символ  - %s; ", i, Alphabet.CIPHER_TO_TEXT.get(String.valueOf(i)));
        }
    }


    private String getOutputFromResult(ProcessingResult processingResult) {
        return processingResult.toString();
    }
}


