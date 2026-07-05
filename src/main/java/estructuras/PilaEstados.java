package estructuras;

public class PilaEstados {
    private NodoEstado top;

    public PilaEstados() {
        this.top = null;
    }

    public void push(String estado) {
        NodoEstado nuevo = new NodoEstado(estado);
        nuevo.setSiguiente(top);
        top = nuevo;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String estado = top.getEstado();
        top = top.getSiguiente();
        return estado;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getEstado();
    }

    public boolean isEmpty() {
        return top == null;
    }


}
