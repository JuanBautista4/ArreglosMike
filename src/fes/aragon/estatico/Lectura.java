package fes.aragon.estatico;

import fes.aragon.excep.IndiceFueraDeRango;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Lectura {
    public static void main(String[] args){
        String archivoCSV = "recursos/floats_two_decimals.csv";
        String linea = "";
        String separador = ",";
        Arreglo<Double> generico=new Arreglo<>(300);
        Double sumatoria=0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                // Usar el separador para dividir las columnas
                String[] datos = linea.split(separador);

                for (String valor : datos) {
                    Double dato = Double.parseDouble(valor);
                    generico.insertar(dato);
                    sumatoria=sumatoria+dato;
                    int n= datos.length;


           }
                generico.imprime();
                Double promedio=sumatoria/300;
                System.out.println("promedio: "+promedio);
                Double min=burbujaMinimo(generico);
                System.out.println("Val Min:"+min);
                Double max=burbujaMaximo(generico);
                System.out.println("Val Max: "+max);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IndiceFueraDeRango e) {
            throw new RuntimeException(e);
        }
    }
    public static <T extends Comparable<T>> T burbujaMinimo(Arreglo<T> arr) throws IndiceFueraDeRango {
        int n = arr.tam();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.recupera(j).compareTo(arr.recupera(j + 1)) > 0) {
                    // Intercambio de elementos
                    arr.intercambiar(j, j + 1);
                }
            }
        }

        // El valor más pequeño estará en la primera posición
        return arr.recupera(0);
    }
    public static <T extends Comparable<T>> T burbujaMaximo(Arreglo<T> arr) throws IndiceFueraDeRango {
        int n = arr.tam();
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {  // Recorre desde el final hacia el inicio
                if (arr.recupera(j).compareTo(arr.recupera(j - 1)) > 0) {
                    arr.intercambiar(j, j - 1);
                }
            }
        }
        return arr.recupera(0);  // El valor más grande estará en la primera posición

    }
}
