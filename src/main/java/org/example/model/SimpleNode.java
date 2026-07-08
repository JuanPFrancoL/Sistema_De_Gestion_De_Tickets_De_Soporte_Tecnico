package org.example.model;

public class SimpleNode {
    public User user;
    public SimpleNode next;

    public SimpleNode(User user) {
        this.user = user;
        this.next = null;
    }
}
