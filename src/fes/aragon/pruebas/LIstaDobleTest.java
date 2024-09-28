package fes.aragon.pruebas;

import fes.aragon.dinamico.ListaDoble;
import fes.aragon.excep.IndiceFueraDeRango;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class LIstaDobleTest {
    public static void main(String[] args) throws IndiceFueraDeRango {
        String AarchivoCSV = "recursos/Datos.csv";
        String linea = "";
        String separador = ",";
        ListaDoble<Integer> Lista = new ListaDoble<>();

        try (BufferedReader br = new BufferedReader(new FileReader(AarchivoCSV))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                for (String valor : datos) {
                    Integer dato = Integer.valueOf(valor);
                    Lista.agregarEnCola(dato);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Elementos de la lista:");
        Lista.imprimirElementos();

        System.out.println("*********|agregarEnCabeza|********");
        System.out.println("Agregando el valor 2 en cabeza");
        Lista.agregarEnCabeza(2);

        System.out.println("*********|agregarEnCola|********");
        System.out.println("agregando el valor 3 en cola");
        Lista.agregarEnCola(3);

        System.out.println("*********|obtenerNodo|********");
        System.out.println("recuperando el dato de la posicion 0: ");
        System.out.println(Lista.obtenerNodo(0));

        System.out.println("*********|esVacia|********");
        System.out.println("comprobando que la lista no sea vacia");
        Lista.esVacia();

        System.out.println("*********|eliminarEnCabeza|********");
        System.out.println("eliminando el primer nodo de la lista (valor 2)");
        Lista.eliminarEnCabeza();

        System.out.println("*********|eliminarEnCola|********");
        System.out.println("eliminando el ultimo nodo de la lista (valor 3)");
        Lista.eliminarEnCola();

        System.out.println("*********|estaEnLista|********");
        System.out.println("buscando el dato 13 en la lista (posicion 0)");
        Lista.estaEnLista(13);

        System.out.println("*********|eliminarEnIndice|********");
        System.out.println("eliminando el nodo en el indice 2 (23)");
        Lista.eliminarEnIndice(2);

        System.out.println("*********|insertarEnIndice|********");
        System.out.println("insertando un nodo con valor 33 en el indice 2");
        Lista.insertarEnIndice(33,2);

        System.out.println("*********|asignar|********");
        System.out.println("asignando el dato 55 al nodo 3 (actualmente contiene el dato 40)");
        Lista.asignar(55,3);

        System.out.println("*********|asignar10|********");
        System.out.println("asignando el dato 99 a todos los datos que actualmente tengan el dato 155");
        Lista.asignar10(155,99,true);

        System.out.println("Lista despues de aplicar todos los metodos");
        Lista.imprimirElementos();


    }
}
