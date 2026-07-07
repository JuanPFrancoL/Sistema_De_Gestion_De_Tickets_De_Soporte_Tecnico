package org.example;

public class Queue {
    Node head;
    Node tail;
    int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(Node node) {
        if (size == 0) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        Node nodeDequeue = head;
        head = head.next;
        size--;
        return nodeDequeue;
    }

    public String printQueueFirstToLast() {
        String text = "";
        Node pointer = head;
        while (pointer != null) {
            text += pointer.toString() + "\n";
            pointer = pointer.next;
        }
        return text;
    }

    public String printQueueLastToFirst() {
        String text = "";
        Node pointer = tail;
        while (pointer != null) {
            text += pointer.toString() + "\n";
            pointer = pointer.previous;
        }
        return text;
    }
}
