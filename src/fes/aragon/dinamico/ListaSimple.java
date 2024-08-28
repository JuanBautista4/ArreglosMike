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
        return longitud;
    }
}
