package org.example.model;

public class SimpleList {
    public SimpleNode head;
    int size;


    public void addNode(User user) {
        SimpleNode newNode = new SimpleNode(user);
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
