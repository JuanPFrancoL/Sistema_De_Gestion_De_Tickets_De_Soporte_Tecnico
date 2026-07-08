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

    public void changeState(ActualState newState) {
        if (this.actualState == newState) {
            return;
        }
        this.actualState = newState;
        this.history.push(String.valueOf(newState));
    }


}
