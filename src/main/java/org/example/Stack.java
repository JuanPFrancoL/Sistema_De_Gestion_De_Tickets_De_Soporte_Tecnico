package org.example;

public class Stack {
    StackNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String estado) {
        StackNode newNode = new StackNode(estado);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String state = top.state;
        top = top.next;
        return state;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return top.state;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
