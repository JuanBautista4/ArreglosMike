package fes.aragon.dinamico;

public class ListaDoble<E> {
    protected NodoDoble<E> cabeza, cola;
    protected int longitud = 0;

    public ListaDoble() {
        cabeza = cola = null;
    }

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

    public int getLongitud() {
        return longitud;
    }

    public void imprimirElementos() {
        for (NodoDoble<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
            System.out.println(tmp.getDato());
        }
    }
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
    public void esVacia() {
        if (cabeza == null && cola == null) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("La lista tiene datos");
        }
    }

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

    public void eliminarEnCola() {
        if (cola != null) {
            cola = cola.getAnterior();
            if (cola != null) {
                cola.setSiguiente(null);
            } else {
                cabeza = null; // Si la lista queda vacía
            }
            longitud--;
        }
    }

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


    public void eliminarEnIndice(int indice) {
        if (indice < 0 || indice >= longitud) {
            System.out.println("Índice fuera de rango");
            return;
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

    public void insertarEnIndice(E dat, int indice) {
        if (indice < 0 || indice > longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
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

    public void asignar(E dat, int indice) {
        if (indice < 0 || indice >= longitud) {
            System.out.println("Índice fuera de rango");
            return;
        }

        NodoDoble<E> actual = cabeza;
        int contador = 0;

        while (contador < indice) {
            actual = actual.getSiguiente();
            contador++;
        }

        actual.setDato(dat);
    }

    public void asignar10(E dato, E nuevoDato, boolean cambiarTodos) {
        NodoDoble<E> actual = cabeza;
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

    public NodoDoble<E> getCabeza() {
        return cabeza;
    }
}

