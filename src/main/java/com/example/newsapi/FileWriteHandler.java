package com.example.newsapi;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriteHandler {
    public void writeToFile(String input, String fileName) throws RuntimeException {
        FileWriter fileWriter = createFileHandle(fileName);
        writeToFile(fileWriter, input);
    }

    private FileWriter createFileHandle(String fileName) {
        try {
            return new FileWriter(fileName);
        } catch (IOException ex) {
            System.out.println("Error while opening file " + fileName + " " + ex.getMessage());
            throw new RuntimeException("FileWriteHandler failed");
        }
    }

    private void writeToFile(FileWriter fileWriter, String input) {
        BufferedWriter writer = new BufferedWriter(fileWriter);
        try {
            writer.write(input);
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file" + ex.getMessage());
            throw new RuntimeException("FileWriteHandler failed");
        }
    }
}
