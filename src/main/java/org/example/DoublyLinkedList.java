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

    public String displayForward() {
        if (head == null) {
            return "No hay tickets en atencion";
        }
        String text = "";
        Node pointer = head;
        while (pointer != null) {
            text += pointer.ticket.toString() + "\n";
            pointer = pointer.next;
        }
        return text;
    }

    public String displayBackward() {
        if (last == null) {
            return "No hay tickets en atencion";
        }
        String text = "";
        Node pointer = last;
        while (pointer != null) {
            text += pointer.ticket.toString() + "\n";
            pointer = pointer.previous;
        }
        return text;
    }

    public boolean changePriority(String number, Priority priority) {
        Ticket ticket = find(number);
        if (ticket == null) {
            return false;
        }
        ticket.priority = priority;
        return true;
    }

    public boolean changeState(String number, ActualState state) {
        Ticket ticket = find(number);
        if (ticket == null) {
            return false;
        }
        ticket.changeState(state);
        return true;
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
