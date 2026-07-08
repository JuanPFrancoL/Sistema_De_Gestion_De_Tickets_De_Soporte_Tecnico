package estructuras;

import modelo.Ticket;

public class Nodo {
    private Ticket ticket;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
        this.anterior = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
