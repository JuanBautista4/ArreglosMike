package fes.aragon.pruebas;
/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel, González Amezquita Héctor Rogelio
Villanueva Ricard

 */
import fes.aragon.dinamico.ListaSimple;
import fes.aragon.excep.IndiceFueraDeRango;

public class ListaSimpleTest2 {
    public static void main(String[] args) throws IndiceFueraDeRango {
        ListaSimple<Integer> ListaSimple = new ListaSimple<>();
        ListaSimple.agregarEnCola(0);
        ListaSimple.agregarEnCola(1);
        ListaSimple.agregarEnCola(2);
        ListaSimple.agregarEnCola(3);
        ListaSimple.agregarEnCola(4);
        ListaSimple.agregarEnCola(5);

ListaSimple.imprimirElementos();

        System.out.println("-----------Primer ejercicio-----------");
        for (int i = 0; i < ListaSimple.getLongitud(); i++) {
            if (i % 2 == 0) {
                ListaSimple.imprimirNodo(i);
            }
        }
        System.out.println("-----------Segundo ejercicio-----------");
        for (int i = 0; i < ListaSimple.getLongitud(); i++) {
            if (i % 2 != 0) {
                System.out.println((ListaSimple.obtenerNodo(i))*2);
            }
        }
        System.out.println("-----------Segundo ejercicio-----------");
        for (int i = 0; i < ListaSimple.getLongitud(); i++) {
            if (i % 2 == 0) {
                ListaSimple.asignar10(ListaSimple.obtenerNodo(i),100,false);
            }
        }
        ListaSimple.imprimirElementos();

        System.out.println("-----------Tercer ejercicio-----------");
        for (int i = 0; i < ListaSimple.getLongitud(); i++) {
            if (i % 2 != 0) {
                ListaSimple.asignar10(ListaSimple.obtenerNodo(i),50,false);
            }
        }
        ListaSimple.imprimirElementos();

        System.out.println("-----------Cuarto ejercicio-----------");
        for (int i = 0; i < ListaSimple.getLongitud(); i++) {
                if(ListaSimple.obtenerNodo(i)==100){
                    ListaSimple.eliminarEnIndice(i);
            }
        }
        ListaSimple.imprimirElementos();
        System.out.println( ListaSimple.getLongitud());
    }
}
