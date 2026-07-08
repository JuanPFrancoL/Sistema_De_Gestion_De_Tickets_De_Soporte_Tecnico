package org.example.model;

public class Node {
    public Ticket ticket;
    public Node next;
    public Node previous;

    public Node(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
        this.previous = null;
    }
}
