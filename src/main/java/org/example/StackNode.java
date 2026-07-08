package org.example;

public class StackNode {
    String state;
    StackNode next;

    public StackNode(String state) {
        this.state = state;
        this.next = null;
    }
}
