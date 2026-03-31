package com.example.junit_practice;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}

