package fes.aragon.dinamico;
import fes.aragon.excep.IndiceFueraDeRango;
/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel, González Amezquita Héctor Rogelio
Villanueva Ricard

 */
public class ListaSimple<E> {
    protected Nodo<E> cabeza, cola;
    protected int longitud=0;

    public ListaSimple(){
        cabeza=cola=null;
    }

    /*
    Método que crea un nuevo nodo de tipo E y lo agrega en la cabeza
    @param dato es el valor de tipo E a ingresar en la lista simple
    */
    public void agregarEnCabeza(E dato){
        cabeza=new Nodo<E>(dato,cabeza);
        if(cola==null){
            cola=cabeza;
        }
        longitud++;
    }
    /*
    Método que crea un nuevo nodo de tipo E y lo agrega en la cola
    @param dato es el valor de tipo E a ingresar en la lista simple
     */
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

    /*
Método que recorre la lista simple e imprime cada uno de los datos dentro de los nodos
 */
    public void imprimirElementos(){
        for(Nodo<E> tmp=cabeza;tmp !=null;tmp=tmp.getSiguiente()){
            System.out.println(tmp.getDato());
        }
    }
    /*
Método que busca un nodo en la lista a partir del índice dado e imprime el dato contenido

@param nod es el valor del índice (int) correspondiente al nodo que se desea imprimir
@return tras cumplirse la condicion if y retornar el valor termina el metodo
@trows IndiceFueraDeRango exepción que se activa cuando el índice nod está fuera de los rangos de la lista simple
 */
    public void imprimirNodo(int nod) throws IndiceFueraDeRango {
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
        throw new IndiceFueraDeRango("indice fuera de rango");
    }
    /*
Método que busca un nodo en la lista a partir del índice dado, si el índice se encuentra dentro del rango retorna el dato, de lo contrario retorna null

@param nod es el valor del índice (int) correspondiente al nodo que se desea imprimir
@return tras cumplirse la condicion if retorna el dato del nodo
@trows IndiceFueraDeRango exepción que se activa cuando el índice nod está fuera de los rangos de la lista simple
*/
    public E obtenerNodo(int nod) throws IndiceFueraDeRango {
        Nodo<E> actual=cabeza;
        int contador=0;
        while(actual!=null){
            if(contador==nod){
                //System.out.println("El nodo de posision "+nod+" tiene el dato: "+actual.getDato());
                return actual.getDato();
            }
            contador++;
            actual=actual.getSiguiente();
        }
        throw new IndiceFueraDeRango("indice fuera de rango");
    }
   
    public int getLongitud() {
        return longitud;
    }

    /*
Método que evalua si la lista simple es vacia o en su defecto contiene datos
*/
    public void esVacia(){//
        if(cabeza==null && cola==null){
            System.out.println("Nodo Vacio");
        }else {
            System.out.println("tiene datos");
        }
    }
    /*
Método que elimina el nodo de la cabeza
*/
    public void eliminarEnCabeza(){//
        Nodo<E> temp;
        if(cabeza!=null){
            temp=cabeza.getSiguiente();
            cabeza=temp;
        }
        longitud--;
    }
    /*
Método que elimina el nodo de la cola
*/
    public void eliminarEnCola(){//
        Nodo<E> temp;
        if(cabeza!=null && cola!=null){
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
                return;
            }

            Nodo<E> actual = cabeza;
            while (actual.getSiguiente() != cola) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(null);
            cola = actual;
        }
        longitud--;
    }
    /*
Método que busca un dato en la lista a partir del mismo

@param dato es el dato que se desea buscar en la lista
@return retorna el índice en el cual se encuentra el dato
*/
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
    /*
Método que elimina el nodo correspondiente al índice indicado
@param ind es el índice sobre el cual se desea eliminar el nodo
@return tras cumplirse alguna de las condiciones termina el metodo
@trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista simple
*/
    public void eliminarEnIndice(int ind) throws IndiceFueraDeRango {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (ind < 0 || ind >= longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }

        Nodo<E> actual = cabeza;
        Nodo<E> anterior = null;
        int contador = 0;

        while (actual != null) {
            if (contador == ind) {
                if (anterior == null) {
                    // El nodo es la cabeza
                    cabeza = actual.getSiguiente();
                } else {
                    // El nodo está en el medio o al final
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() == null) {
                        // es el último nodo
                        cola = anterior;
                    }
                }
                longitud--;
                System.out.println("Nodo en la posición " + ind + " eliminado");
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
            contador++;
        }
    }

    /*
Método que crea un nuevo nodo y un dato correspondiente en el índice indicado
@param dat es el dato correspondiente al nuevo nodo
@param índice es el valor del índice en el cual se agrega el nuevo nodo
@trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista simple
*/
    public void insertarEnIndice(E dat, int indice) throws IndiceFueraDeRango {
        if (indice < 0 || indice > longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
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
    /*
Método que asigna un dato de tipo E en un nodo existente
@param dat es el dato que se asignara en el nodo señalado por el índice
@param índice es el valor del índice en el cual se asignara el dato
@trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista simple
*/
    public void asignar(E dat, int indice) throws IndiceFueraDeRango {
        if (indice < 0 || indice >= longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
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
    /*
Método que cambia uno o todos los datos de tipo E deseados a un nuevo dato E
@param dat es el dato que será remplazado por un nuevo valor
@param nuevoDato es el dato que sustituye al anterior
@param cambiarTodos es un parametro boolean que controla si se desea sustituir la primera coincidencia en dat o en si defecto todos los datos iguales a dat en la lista
@trows IndiceFueraDeRango exepción que se activa cuando dat no esta en la lista
*/
    public void asignar10(E dat, E nuevoDato, boolean cambiarTodos) throws IndiceFueraDeRango {
        Nodo<E> actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {
            if (actual.getDato().equals(dat)) {
                actual.setDato(nuevoDato);
                encontrado = true;

                if (!cambiarTodos) {
                    return;
                }
            }
            actual = actual.getSiguiente();
        }

        if (!encontrado) {
            throw new IndiceFueraDeRango("valor no encontrado");
        }
    }


}
