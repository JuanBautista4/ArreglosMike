package fes.aragon.estatico;
import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.estatico.Arreglo;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Lectura {
    public static void main(String[] args) throws IndiceFueraDeRango {
        String archivoCSV = "ruta/del/archivo.csv";
        String linea = "";
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                // Usar el separador para dividir las columnas
                String[] datos = linea.split(separador);

                // Imprimir o procesar los datos
                System.out.println("ID: " + datos[0] + ", Nombre: " + datos[1] + ", Edad: " + datos[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
