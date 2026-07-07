package org.example;

import java.io.*;

public class FileManager {
    SimpleList simpleList = new SimpleList();
    File file = new File("src/main/resources/input/usuarios.txt");

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] partes = line.split(",");
                simpleList.addNode(new User(partes[0], partes[1]));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            SimpleNode pointer = simpleList.head;
            while (pointer != null) {
                bufferedWriter.write(pointer.user.toString());
                bufferedWriter.newLine();
                pointer = pointer.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
