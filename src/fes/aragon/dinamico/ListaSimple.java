package fes.aragon.dinamico;

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

    public int getLongitud() {
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
    public void esVacia(){
        if(cabeza==null && cola==null){
            System.out.println("Nodo Vacio");
        }else {
            System.out.println("tiene datos");
        }
    }
    public void eliminarEnCabeza(){
        Nodo<E> temp;
        if(cabeza!=null){
            temp=cabeza.getSiguiente();
            cabeza=temp;
        }
    }
    public void eliminarEnCola(){
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
    }
    public int estaEnLista(E dato) {
        int indic = -1;
        int lon = 0;
        for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            lon++;
            if (tmp.getDato().equals(dato)) {
                indic = lon;
                break; // Salir del bucle al encontrar el dato
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
        Nodo<E> actual = cabeza;
        Nodo<E> anterior = null;
        int contador = 0;

        while (actual != null) {
            if (contador == nod) {
                if (anterior == null) {
                    // El nodo a eliminar es la cabeza
                    cabeza = actual.getSiguiente();
                } else {
                    // El nodo a eliminar está en medio o al final
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() == null) {
                        // Si estamos eliminando el último nodo, actualizar la referencia de la cola si la tienes
                        cola = anterior;
                    }
                }
                System.out.println("Nodo en la posición " + nod + " eliminado");
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
            contador++;
        }

        System.out.println("Índice fuera de rango");
    }
    //QUEDO HASTA EL PROBLEMA 7

}
