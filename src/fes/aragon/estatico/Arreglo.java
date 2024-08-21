package fes.aragon.estatico;
import fes.aragon.excep.IndiceFueraDeRango;


/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel
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
    @throws IndiceFueraDeRango exepción que se activa cuando se excede el índice
     */
    public void insertar(E x)throws  IndiceFueraDeRango {
        if (indice < l.length) {
            l[indice] = x;
            indice++;
        } else {
            throw new IndiceFueraDeRango("Indice fuera de rango");
        }
    }

    /*
Método que localiza un valor de tipo E del arreglo y retorna el índice

@param x es el valor de tipo E a buscar en el arreglo
@return se retorna -1 si el valor no se encuentra en la lista, en caso contrario se retorna el indice
 */
    public Integer localiza(E x) {
        for (int i = 0; i<=indice; i++) {
            if (l[i].equals(x)) {
                return i;
            }
        }
        return -1;

    }


    /*
Método que recupera un valor de tipo E del arreglo mediante el índice, retorna el valor de tipo E

@param x índica el índice del elemento a recuperar
@return se retorna el valor de tipo E correspondiente al índice
@trows IndiceFueraDeRango exepción que se activa cuando el índice x está fuera de los rangos del arreglo
 */
    public E recupera(int x) throws IndiceFueraDeRango{
        if (x>indice||x > l.length || x < 0) {
            throw new IndiceFueraDeRango("Indice fuera de rango");
        } else {
            @SuppressWarnings("unchecked")
            final E e = (E) l[x];
            return e;
        }
    }

    /*
Método que elimina un valor de tipo E del arreglo mediante el índice indicado

@param x índica el índice del elemento a eliminar
@trows IndiceFueraDeRango exepción que se activa cuando el índice x está fuera de los rangos del arreglo
 */
    public void suprime(int x) throws IndiceFueraDeRango{
        if (x>l.length||x > indice || x < 0) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        } else {
            l[x] = null;
        }
    }

    /*
    Metodo que recupera el valor E siguiente al índice indicado

    @param x índica el valor del índice
    @return se retorna el valor E correspondiente a la una posicion siguiente del índice indicado
    @trows IndiceFueraDeRango exepción que se activa cuando el índice x está fuera de los rangos del arreglo
     */
    public E siguiente(int x)throws IndiceFueraDeRango{
        if (x>indice||x >= l.length || x < 0) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }
        else
        {
            for (int i = 0; i < l.length; i++) {
                if (x == i) {
                    @SuppressWarnings("unchecked")
                    final E e = (E) l[x + 1];
                    return e;
                }
            }
        }
        return null;
    }

    /*
    Metodo que recupera el valor E anterior al índice indicado

    @param x índica el valor del índice
    @return se retorna el valor E correspondiente a la una posicion anterior del índice indicado
    @trows IndiceFueraDeRango exepción que se activa cuando el índice x está fuera de los rangos del arreglo o se quiere recuperar el valor anterior de la posicion 0 del arreglo
     */
    public E anterior(int x)throws IndiceFueraDeRango {
        if (x>indice||x > l.length || x <= 0) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }
        else
        {
            for (int i = 0; i < l.length; i++) {
                if (x == i) {
                    @SuppressWarnings("unchecked")
                    final E e = (E) l[x - 1];
                    return e;
                }
            }
        }
        return null;
    }
    //para el metodo limpiar, reiniciar el indice a 0 y asignarle al indice 0 eel valor nulo
    public void limpiar(){
        indice=0;
        l[indice]=null;
        System.out.println("--------");
        System.out.println(" "+l[indice]);
    }
    public E primero(){
        @SuppressWarnings("unchecked")
        final E e = (E) l[0];
        return e;
    }
    public void imprime(){
        for (int i = 0; i < indice ; i++) {
            System.out.println(l[i]);
        }
    }
    public void asignar(int x, E a) throws IndiceFueraDeRango {
        if (x<indice||x > l.length || x <= 0) {
            throw new IndiceFueraDeRango("indice fuera de rango");
        }
        else
        {
            l[x]=a;
        }
    }
    public void intercambiar(int i, int j) {
        if (i >= 0 && i < indice && j >= 0 && j < indice) {
            E temp = (E) l[i];
            l[i] = l[j];
            l[j] = temp;
        }
    }
    public int tam(){
        return indice;
    }


}








