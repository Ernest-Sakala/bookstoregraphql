package com.cs.unza.zm.bookstore.config.graphql;


public class FileUploadResult {

    private String fileName;
    private String filePath;
    private String message;

    public FileUploadResult(String fileName, String filePath, String message) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.message = message;
    }

    // Getters and setters
    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getMessage() {
        return message;
    }
}
