package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    File file;
    SimpleList simpleList = new SimpleList();

    public void readFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                simpleList.addNode(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
