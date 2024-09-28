package fes.aragon.pruebas;
/*
Clase que tiene funciones para utilizar arreglos de tipo E
@author Bautista Solis Juan Pedro, Calderon Almanza Marvin Daniel, González Amezquita Héctor Rogelio
Villanueva Ricard

 */

import fes.aragon.dinamico.ListaSimple;
import fes.aragon.excep.IndiceFueraDeRango;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListaSimpleTest {
    public static void main(String[] args) throws IndiceFueraDeRango {
        String AarchivoCSV = "recursos/datos_dobles_horizontal.csv";
        String linea = "";
        String separador = ",";
        ListaSimple<Double> ListaCabeza = new ListaSimple<>();
        ListaSimple<Double> ListaCola = new ListaSimple<>();

        try (BufferedReader br = new BufferedReader(new FileReader(AarchivoCSV))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                for (String valor : datos) {
                    Double dato = Double.parseDouble(valor);
                    ListaCabeza.agregarEnCabeza(dato);
                    ListaCola.agregarEnCola(dato);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("------------------------------");
        System.out.println("Agregando a cabeza");
        System.out.println("Numero de elementos:" + ListaCabeza.getLongitud());
        System.out.println("------------------------------");
        ListaCabeza.imprimirElementos();
        System.out.println("------------------------------");
        System.out.println("Agregando a cola");
        System.out.println("Numero de elementos:" + ListaCola.getLongitud());
        System.out.println("------------------------------");
        ListaCola.imprimirElementos();
        ListaCabeza.imprimirNodo(2);
        ListaCabeza.esVacia();
        ListaCabeza.getLongitud();
        System.out.println("---------------Eliminado en cabeza-----");
        ListaCabeza.eliminarEnCabeza();
        ListaCabeza.imprimirElementos();
        System.out.println("---------------Eliminado en cola-------");
        ListaCabeza.eliminarEnCola();
        ListaCabeza.imprimirElementos();
        ListaCabeza.estaEnLista(90.12);
        System.out.println("---------------------------------------------");
        ListaCabeza.eliminarEnIndice(2);
        ListaCabeza.imprimirElementos();
        ListaCabeza.getLongitud();
        System.out.println("------METODO 8------------------------------------");
        ListaCabeza.insertarEnIndice(20.1, 2);
        ListaCabeza.imprimirElementos();
        ListaCabeza.getLongitud();
        System.out.println("------METODO 9------------------------------------");
        ListaCabeza.asignar(20., 2);
        ListaCabeza.imprimirElementos();
        ListaCabeza.getLongitud();
        System.out.println("------METODO 10------------------------------------");
        ListaCabeza.asignar10(20., 32.54, false);
        ListaCabeza.imprimirElementos();
        ListaCabeza.getLongitud();
        System.out.println("------Fin------------------------------------");
    }
}