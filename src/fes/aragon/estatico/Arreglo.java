package fes.aragon.estatico;



/*
Clase que tiene funciones para utilizar arreglos de tipo E
 */
public class Arreglo<E> {
    private int indice = 0;
    private final Object[] l;

    public Arreglo(int numeroElementos) {
        this.l = new Object[numeroElementos];
    }


    /*
    Método que inserta un valor de tipo E en el arreglo de manera consecutiva

    @param x es el parametro que se recibe el cual se agregara a la lista
    @throws IndiceFueraDeRango exepción que se activa cuando se excede el indice
     */
    public void insertar(E x)/*throws  IndiceFueraDeRango */ {
        if (indice < l.length) {
            l[indice] = x;
            indice++;
        } else {
            //throw new IndiceFueraDeRango("Indice fuera de rango");
        }
    }

    /*
Método que localiza un valor de tipo E del arreglo y retorna el indice

@param x es el valor de tipo E a buscar en el arreglo
@return se retorna -1 si el valor no se encuentra en la lista, en caso contrario se retorna el indice
 */
    public Integer localiza(E x) {
        for (int i = 0; i < l.length; i++) {
            if (l[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }


    /*
Método que recupera un valor de tipo E del arreglo mediante el indice, retorna el valor de tipo E

@param x indica el indice del elemento a recuperar
@return se retorna el valor de tipo E correspondiente al indice
@trows IndiceFueraDeRango exepción que se activa cuando el indice x esta fuera de los rangos del arreglo
 */
    public E recupera(int x)/*throws IndiceFueraDeRango */ {
        if (x < l.length || x < 0) {
            //throw new IndiceFueraDeRango("Indice fuera de rango");
        } else {
            final E e = (E) l[x];
            return e;
        }
        return null;
    }

    /*
Método que elimina un valor de tipo E del arreglo mediante el indice indicado

@param x indica el indice del elemento a eliminar
@trows IndiceFueraDeRango exepción que se activa cuando el indice x esta fuera de los rangos del arreglo
 */
    public void suprime(int x)/*throws IndiceFueraDeRango*/ {
        if (x > l.length || x < 0) {
            //throw new IndiceFueraDeRango("indice fuera de rango");
        } else {
            l[x] = null;
        }
    }

    /*
    Metodo que recupera el valor E anterior al indice indicado

    @param x indica el valor del indice
    @return se retorna el valor E correspondiente a la una posicion anterior del indice indicado
    @trows IndiceFueraDeRango exepción que se activa cuando el indice x esta fuera de los rangos del arreglo o se quiere recuperar el valor anterior de la posicion 0 del arreglo
     */
    public E anterior(int x) {
        if (x > l.length || x <= 0) {
            //throw new IndiceFueraDeRango("indice fuera de rango");
        }
        else
        {
            for (int i = 0; i < l.length; i++) {
                if (x == i) {
                    final E e = (E) l[x - 1];
                    return e;
                }
            }
        }
        return null;
    }

}








