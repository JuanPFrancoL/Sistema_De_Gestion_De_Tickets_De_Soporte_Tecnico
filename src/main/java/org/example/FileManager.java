package org.example;

import java.io.*;

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
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            SimpleNode pointer = simpleList.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = bufferedWriter.write(pointer.line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
