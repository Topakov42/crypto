package com.javarush.crypto.exception;

public class CipherException extends Exception {


    public CipherException(String message) {
        super(message);
    }


    //не проверяемые исключения
    public CipherException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
