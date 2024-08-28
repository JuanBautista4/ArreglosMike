package fes.aragon.modelo;

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
                // Usar el separador para dividir las columnas
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

    }
}