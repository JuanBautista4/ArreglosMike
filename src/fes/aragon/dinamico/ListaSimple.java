package fes.aragon.dinamico;

import com.sun.source.tree.NewArrayTree;

public class ListaSimple<E> {
    protected Nodo<E> cabeza, cola;
    protected int longitud=0;

    public ListaSimple(){
        cabeza=cola=null;
    }

    public void agregarEnCabeza(E dato){
        cabeza=new Nodo<E>(dato,cabeza);
        if(cola==null){
            cola=cabeza;
        }
        longitud++;
    }

    public void agregarEnCola(E dato){
        if(cabeza==null){
            cabeza=cola=new Nodo<E>(dato);
        }
        else{
            cola.setSiguiente(new Nodo<E>(dato));
            cola=cola.getSiguiente();
        }
        longitud++;
    }
    public void imprimirElementos(){
        for(Nodo<E> tmp=cabeza;tmp !=null;tmp=tmp.getSiguiente()){
            System.out.println(tmp.getDato());
        }
    }
    public void imprimirNodo(int nod){
        Nodo<E> actual=cabeza;
        int contador=0;
        while(actual!=null){
            if(contador==nod){
                System.out.println("El nodo de posision "+nod+" tiene el dato: "+actual.getDato());
            return;
            }
            contador++;
            actual=actual.getSiguiente();
        }
        System.out.println("Indice fuera de rango");
    }

    public int getLongitud() {//
        System.out.println(""+longitud);
        return longitud;
    }
    public boolean eliminarConUnElemento(E x){
        boolean elim=false;
        if(cabeza!=null){
            if(cabeza==cola && cabeza.getDato()==x){
                cabeza=null;
                cola=null;
                elim=true;
                longitud--;
            }else{
                elim=false;
            }
        }
        return elim;
    }
    public void esVacia(){//
        if(cabeza==null && cola==null){
            System.out.println("Nodo Vacio");
        }else {
            System.out.println("tiene datos");
        }
    }
    public void eliminarEnCabeza(){//
        Nodo<E> temp;
        if(cabeza!=null){
            temp=cabeza.getSiguiente();
            cabeza=temp;
        }
        longitud--;
    }
    public void eliminarEnCola(){//
        Nodo<E> temp;
        if(cabeza!=null && cola!=null){
            if (cabeza == cola) {
                // Solo hay un elemento en la lista
                cabeza = null;
                cola = null;
                return;
            }

            // Encontrar el penúltimo nodo
            Nodo<E> actual = cabeza;
            while (actual.getSiguiente() != cola) {
                actual = actual.getSiguiente();
            }

            // Eliminar el último nodo
            actual.setSiguiente(null);
            cola = actual;
        }
        longitud--;
    }
    public int estaEnLista(E dato) {//
        int indic = -1;
        int lon = 0;
        for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            lon++;
            if (tmp.getDato().equals(dato)) {
                indic = lon;
                System.out.println("elemento encontrado en el indice: "+indic);
                return indic;
            }
        }
        System.out.println("indice eliminado: "+indic);
        return indic;
    }
    public void eliminarEnIndice(int nod) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (nod < 0 || nod >= longitud) {
            System.out.println("Índice fuera de rango");
            return;
        }

        Nodo<E> actual = cabeza;
        Nodo<E> anterior = null;
        int contador = 0;

        // Recorremos la lista hasta encontrar el nodo a eliminar
        while (actual != null) {
            if (contador == nod) {
                if (anterior == null) {
                    // El nodo a eliminar es la cabeza
                    cabeza = actual.getSiguiente();
                } else {
                    // El nodo a eliminar está en el medio o al final
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() == null) {
                        // Si estamos eliminando el último nodo, actualizar la referencia de la cola
                        cola = anterior;
                    }
                }
                longitud--;  // Reducir la longitud de la lista
                System.out.println("Nodo en la posición " + nod + " eliminado");
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
            contador++;
        }
    }


    public void insertarEnIndice(E dat, int indice) {
        if (indice < 0 || indice > longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }

        Nodo<E> nuevoNodo = new Nodo<>(dat);

        if (indice == 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            if (longitud == 0) {
                cola = nuevoNodo; // este es solo si la lista es vacia
            }
        } else {
            Nodo<E> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);

            if (indice == longitud) {
                cola = nuevoNodo;
            }
        }

        longitud++;
    }

    public void asignar(E dat, int indice) {
        if (indice < 0 || indice >= longitud) {
            System.out.println("Índice fuera de rango");
            return;
        }

        Nodo<E> actual = cabeza;
        int lon = 0;

        while (actual != null) {
            if (lon == indice) {
                actual.setDato(dat);
                return;
            }
            actual = actual.getSiguiente();
            lon++;
        }
    }
    public void asignar10(E dato, E nuevoDato, boolean cambiarTodos) {
        Nodo<E> actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                actual.setDato(nuevoDato);
                encontrado = true;

                if (!cambiarTodos) {
                    return;
                }
            }
            actual = actual.getSiguiente();
        }

        if (!encontrado) {
            System.out.println("El dato no se encontró en la lista.");
        }
    }


}
