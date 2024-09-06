package fes.aragon.dinamico;

public class NodoDoble<E> {
    private E dato;
    private NodoDoble<E> siguiente;
    private NodoDoble<E> anterior;

    public NodoDoble(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public NodoDoble(E dato, NodoDoble<E> siguiente, NodoDoble<E> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoDoble<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<E> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<E> anterior) {
        this.anterior = anterior;
    }
}

