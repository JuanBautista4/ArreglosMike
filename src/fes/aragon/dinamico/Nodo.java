package fes.aragon.dinamico;
/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel, González Amezquita Héctor Rogelio
Villanueva Ricard

 */
public class Nodo<E> {
    private E dato;
  private Nodo<E> siguiente;

  public Nodo(E dato){
      this  (dato,null);
  }
    public Nodo(E dato,Nodo<E> siguiente){
        this.dato=dato;
        this.siguiente=siguiente;
    }
    public E getDato(){
      return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
}
