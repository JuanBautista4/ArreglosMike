package fes.aragon.modelo;
/*1,2,3,4,5,6*/
import fes.aragon.dinamico.ListaSimple;
import fes.aragon.dinamico.Nodo;
import fes.aragon.estatico.Arreglo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClienteNodo {
    public static void main(String[] args) {
        String AarchivoCSV = "recursos/Datos.csv";
        String linea = "";
        String separador = ",";
        ListaSimple<Double> ListaCabeza = new ListaSimple<>();
        ListaSimple<Double> ListaCola=new ListaSimple<>();

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
        System.out.println("Numero de elementos:"+ListaCabeza.getLongitud());
        System.out.println("------------------------------");
        ListaCabeza.imprimirElementos();
        System.out.println("------------------------------");
        System.out.println("Agregando a cola");
        System.out.println("Numero de elementos:"+ListaCola.getLongitud());
        System.out.println("------------------------------");
        ListaCola.imprimirElementos();
        ListaCabeza.imprimirNodo(299);
        ListaCabeza.esVacia();
        ListaCabeza.getLongitud();
        System.out.println("---------------Eliminado en cabeza-----");
        ListaCabeza.eliminarEnCabeza();
        ListaCabeza.imprimirElementos();
        System.out.println("---------------Eliminado en cola-------");
        ListaCabeza.eliminarEnCola();
        ListaCabeza.imprimirElementos();
        ListaCabeza.estaEnLista(141.0);
        System.out.println("---------------------------------------------");
        ListaCabeza.eliminarEnIndice(2);
        ListaCabeza.imprimirElementos();
    }
}