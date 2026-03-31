package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class FileProcessorTest {

    FileProcessor processor = new FileProcessor();

    @Test
    void testWriteAndReadFile() throws IOException {
        String filename = "testfile.txt";
        String content = "Hello JUnit";

        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);

        assertEquals(content, result);

        new File(filename).delete();
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        String filename = "existstest.txt";

        processor.writeToFile(filename, "Test");

        File file = new File(filename);
        assertTrue(file.exists());

        file.delete();
    }

    @Test
    void testReadNonExistingFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}

