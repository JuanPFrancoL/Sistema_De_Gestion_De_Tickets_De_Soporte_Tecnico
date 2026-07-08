package org.example;

public class StackNode {
    String state;
    StackNode next;

    public StackNode(String state) {
        this.state = String.valueOf(ActualState.NEW);
        this.next = null;
    }
}
