package org.example;

public class Node {
    Ticket ticket;
    Node next;
    Node previous;

    public Node(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
        this.previous = null;
    }
}
