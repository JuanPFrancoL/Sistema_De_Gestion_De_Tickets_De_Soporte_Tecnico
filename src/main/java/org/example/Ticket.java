package org.example;

public class Ticket {
    String number;
    String name;
    String description;
    Priority priority;
    ActualState actualState;
    Stack history;

    public Ticket(String number, String name, String description, Priority priority) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.actualState = ActualState.NEW;
        history = new Stack();
        history.push(String.valueOf(ActualState.NEW));
    }

    public String toString() {
        return "Number: " + number + "\nName: " + name + "\nDescription: " + description + "\nPriority: " + priority + "\n-----------------------------";
    }


}
