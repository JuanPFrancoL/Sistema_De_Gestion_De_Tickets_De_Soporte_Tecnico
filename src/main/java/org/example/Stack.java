package org.example;

public class Stack {
    StackNode top;
    int size;

    public Stack() {
        this.top = null;
    }

    public void push(String estado) {
        StackNode newNode = new StackNode(estado);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String state = top.state;
        top = top.next;
        size--;
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

    public String printStack() {
        if (top == null) {
            return "No hay estados para mostrar";
        }
        
        String text = "";
        StackNode pointer = top;

        while (pointer != null) {
            text += pointer.state + "\n";
            pointer = pointer.next;
        }
        return text;
    }

    public int getSize() {
        return size;
    }

}
