package com.javarush.crypto.model;

public class ProcessingResult {
    private final boolean succes;
    private final String message;
    private final String inputPreview;
    private final String outputPreview;

    public ProcessingResult(boolean succes, String message, String inputPreview, String outputPreview) {
        this.succes = succes;
        this.message = message;
        this.inputPreview = inputPreview;
        this.outputPreview = outputPreview;
    }

    public boolean isSucces() {
        return succes;
    }

    public String getMessage() {
        return message;
    }

    public String getInputPreview() {
        return inputPreview;
    }

    public String getOutputPreview() {
        return outputPreview;
    }
}
