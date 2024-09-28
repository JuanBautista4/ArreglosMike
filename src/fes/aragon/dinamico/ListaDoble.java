package fes.aragon.dinamico;

import fes.aragon.excep.IndiceFueraDeRango;
/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel, González Amezquita Héctor Rogelio
Villanueva Ricard

 */
public class ListaDoble<E> {
    protected NodoDoble<E> cabeza, cola;
    protected int longitud = 0;

    public ListaDoble() {
        cabeza = cola = null;
    }
    /*
        Método que crea un nuevo nodo doble de tipo E y lo agrega en la cabeza
        @param dato es el valor de tipo E a ingresar en la lista doble
        */
    public void agregarEnCabeza(E dato) {
        NodoDoble<E> nuevoNodo = new NodoDoble<>(dato, cabeza, null);
        if (cabeza != null) {
            cabeza.setAnterior(nuevoNodo);
        }
        cabeza = nuevoNodo;

        if (cola == null) {
            cola = cabeza;
        }
        longitud++;
    }
    /*
       Método que crea un nuevo nodo doble de tipo E y lo agrega en la cola de la lista doble
       @param dato es el valor de tipo E a ingresar en la lista doble
        */
    public void agregarEnCola(E dato) {
        if (cola == null) {
            cabeza = cola = new NodoDoble<>(dato, null, null);
        } else {
            NodoDoble<E> nuevoNodo = new NodoDoble<>(dato, null, cola);
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        longitud++;
    }

    /*
Método que recorre la lista doble e imprime cada uno de los datos dentro de los nodos dobles
 */
    public void imprimirElementos() {
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            System.out.println(tmp.getDato());
        }
    }
    /*
Método que busca un nodo doble en la lista doble a partir del índice dado, si el índice se encuentra dentro del rango retorna el dato, de lo contrario retorna null

@param nod es el valor del índice (int) correspondiente al nodo doble que se desea imprimir
@return tras cumplirse la condicion if retorna el dato del nodo doble
*/
    public E obtenerNodo(int nod) {
        if (nod < 0 || nod >= longitud) {
            System.out.println("Índice fuera de rango");
            return null;
        }

        NodoDoble<E> actual;
        int contador = 0;

        // Decidimos si es más eficiente recorrer desde la cabeza o desde la cola
        if (nod < longitud / 2) {
            // Recorrer desde la cabeza
            actual = cabeza;
            while (contador < nod) {
                actual = actual.getSiguiente();
                contador++;
            }
        } else {
            // Recorrer desde la cola
            actual = cola;
            contador = longitud - 1;
            while (contador > nod) {
                actual = actual.getAnterior();
                contador--;
            }
        }

        return actual.getDato();
    }
    /*
Método que comprueba si la lista doble es vacia o en su defecto contiene datos
*/
    public void esVacia() {
        if (cabeza == null && cola == null) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("La lista tiene datos");
        }
    }
    /*
 Método que elimina el nodo doble que se encuentre en la cabeza
 */
    public void eliminarEnCabeza() {
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null);
            } else {
                cola = null; // Si la lista queda vacía
            }
            longitud--;
        }
    }
    /*
Método que elimina el nodo doble que esté en la cola
*/
    public void eliminarEnCola() {
        if (cola != null) {
            cola = cola.getAnterior();
            if (cola != null) {
                cola.setSiguiente(null);
            } else {
                cabeza = null;
            }
            longitud--;
        }
    }
    /*
Método que busca un dato en la lista a partir del mismo

@param dato es el dato E que se desea buscar en la lista
@return retorna el índice en el cual se encuentra el dato
*/
    public int estaEnLista(E dato) {
        int indice = -1;
        int contador = 0;

        NodoDoble<E> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                indice = contador;
                System.out.println("Elemento encontrado en el índice: " + indice);
                return indice;
            }
            actual = actual.getSiguiente();
            contador++;
        }

        System.out.println("Elemento no encontrado. Índice: " + indice);
        return indice;
    }

    /*
Método que elimina el nodo correspondiente al índice indicado
@param ind es el índice sobre el cual se desea eliminar el nodo doble
@return tras cumplirse alguna de las condiciones termina el metodo
@trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista doble
*/
    public void eliminarEnIndice(int indice) throws IndiceFueraDeRango {
        if (indice < 0 || indice >= longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }

        if (indice == 0) {
            eliminarEnCabeza();
            return;
        }

        if (indice == longitud - 1) {
            eliminarEnCola();
            return;
        }

        NodoDoble<E> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        actual.getAnterior().setSiguiente(actual.getSiguiente());
        actual.getSiguiente().setAnterior(actual.getAnterior());

        longitud--;
    }
    /*
   Método que crea un nuevo nodo doble y un dato correspondiente en el índice indicado
   @param dat es el dato correspondiente al nuevo nodo doble
   @param índice es el valor del índice en el cual se agrega el nuevo nodo doble
   @trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista doble
   */
    public void insertarEnIndice(E dat, int indice) throws IndiceFueraDeRango {
        if (indice < 0 || indice > longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }

        NodoDoble<E> nuevoNodo = new NodoDoble<>(dat);

        // si se inserta en la cabeza
        if (indice == 0) {
            nuevoNodo.setSiguiente(cabeza);
            if (cabeza != null) {
                cabeza.setAnterior(nuevoNodo);
            }
            cabeza = nuevoNodo;
            if (longitud == 0) {
                cola = nuevoNodo; // Si la lista estaba vacia
            }
        } else if (indice == longitud) { // si se quiere insertar al final
            nuevoNodo.setAnterior(cola);
            if (cola != null) {
                cola.setSiguiente(nuevoNodo);
            }
            cola = nuevoNodo;
        } else {
            NodoDoble<E> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(nuevoNodo);
            }
            actual.setSiguiente(nuevoNodo);
        }

        longitud++;
    }
    /*
    Método que asigna un dato de tipo E en un nodo existente
    @param dat es el dato que se asignara en el nodo señalado por el índice
    @param índice es el valor del índice en el cual se asignara el dato
    @trows IndiceFueraDeRango exepción que se activa cuando el índice está fuera de los rangos de la lista doble
    */
    public void asignar(E dat, int indice) throws IndiceFueraDeRango {
        if (indice < 0 || indice >= longitud) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }

        NodoDoble<E> actual = cabeza;
        int contador = 0;

        while (contador < indice) {
            actual = actual.getSiguiente();
            contador++;
        }

        actual.setDato(dat);
    }
    /*
    Método que cambia uno o todos los datos de tipo E deseados a un nuevo dato E
    @param dat es el dato que será remplazado por un nuevo valor
    @param nuevoDato es el dato que sustituye al anterior
    @param cambiarTodos es un parametro boolean que controla si se desea sustituir la primera coincidencia en dat o en si defecto todos los datos iguales a dat en la lista
    @trows IndiceFueraDeRango exepción que se activa cuando dat no esta en la lista doble
    */
    public void asignar10(E dat, E nuevoDato, boolean cambiarTodos) throws IndiceFueraDeRango {
        NodoDoble<E> actual = cabeza;
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

    public NodoDoble<E> getCabeza() {
        return cabeza;
    }
}

