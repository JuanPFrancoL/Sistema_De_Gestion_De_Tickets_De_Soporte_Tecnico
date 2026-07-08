package org.example;

public class DoublyLinkedList {
    Node head;
    Node last;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(Ticket ticket) {
        Node newNode = new Node(ticket);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    public Ticket find(String number) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.ticket.number.equals(number)) {
                return pointer.ticket;
            }
            pointer = pointer.next;
        }
        return null;
    }

    public void displayForward() {
        Node pointer = head;
        while (pointer != null) {
            System.out.println(pointer.ticket);
            pointer = pointer.next;
        }
    }

    public void displayBackward() {
        Node pointer = last;
        while (pointer != null) {
            System.out.println(pointer.ticket);
            pointer = pointer.previous;
        }
    }

    public void changePriority(String number, Priority priority) {
        Ticket ticket = find(number);
        ticket.priority = priority;
    }

    public void changeState(String number, ActualState state) {
        Ticket ticket = find(number);
        ticket.description
        ticket.actualState = state;

    }

    public Ticket close(String number) {
        Node pointer = findNode(number);
        if (pointer == null) {
            return null;
        }
        if (head == last) {
            head = null;
            last = null;
        } else if (pointer == head) {
            head = head.next;
            head.previous = null;
        } else if (pointer == last) {
            last = last.previous;
            last.next = null;
        } else {
            pointer.previous.next = pointer.next;
            pointer.next.previous = pointer.previous;
        }
        size--;
        return pointer.ticket;
    }

    public Node findNode(String number) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.ticket.number.equals(number)) {
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }


}
