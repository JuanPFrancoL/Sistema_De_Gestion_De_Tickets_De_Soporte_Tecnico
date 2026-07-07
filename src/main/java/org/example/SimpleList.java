package org.example;

public class SimpleList {
    SimpleNode head;
    int size;


    public void addNode(String line) {
        SimpleNode newNode = new SimpleNode(line);
        SimpleNode pointer = head;
        if (head == null) {
            head = newNode;
        } else {
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
        size++;
    }
}
