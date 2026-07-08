package modelo;

public class Ticket {
    private int numero;
    private String nombreCliente;
    private String asunto;
    private String prioridad;
    private String estado;

    public Ticket(int numero, String nombreCliente, String asunto, String prioridad, String estado) {
        this.numero = numero;
        this.nombreCliente = nombreCliente;
        this.asunto = asunto;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
