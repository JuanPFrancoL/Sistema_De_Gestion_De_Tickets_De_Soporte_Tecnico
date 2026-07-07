package org.example;

public class SimpleNode {
    User user;
    SimpleNode next;

    public SimpleNode(User user) {
        this.user = user;
        this.next = null;
    }
}
