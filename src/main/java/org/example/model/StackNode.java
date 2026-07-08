package org.example.model;

public class StackNode {
    public String state;
    public StackNode next;

    public StackNode(String state) {
        this.state = state;
        this.next = null;
    }
}
