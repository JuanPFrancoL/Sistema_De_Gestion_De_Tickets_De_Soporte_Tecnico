package org.example;

public class Ticket {
    int number;
    String name;
    String description;
    Priority priority;
    ActualState actualState;

    
    public Ticket(int number, String name, String description, Priority priority) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.actualState = ActualState.NEW;
    }


}
