package fes.aragon.estatico;

import fes.aragon.excep.IndiceFueraDeRango;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Lectura {
    public static void main(String[] args){
        String archivoCSV = "/home/marvd/Descargas/floats_two_decimals.csv";
        String linea = "";
        String separador = ",";
        Arreglo<Double> generico=new Arreglo<>(300);

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                // Usar el separador para dividir las columnas
                String[] datos = linea.split(separador);

                for (String valor : datos) {
                    Double dato = Double.parseDouble(valor);
                    generico.insertar(dato);
           }
                generico.imprime();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IndiceFueraDeRango e) {
            throw new RuntimeException(e);
        }
    }

}
