package fes.aragon.ficheros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopiarBytes2 {
    public static void main(String[] args) {
        try {
            CopiarBytes2 cp = new CopiarBytes2();
            cp.copiarArchivo();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void copiarArchivo() throws IOException {
        //objeto para el flujo de entrada
        FileInputStream in = null;
        //objeto para el flujo de salida
        FileOutputStream out = null;
        try {
            String nombreArchivo = "recursos/prueba1.pdf";
            //Ubicación del archivo
            in = new FileInputStream(nombreArchivo);
            //Se crea un arreglo de bytes, con el tamaño del archivo a copiar
            byte[] datos = new byte[in.available()];
            in.read(datos);
            //Salida del Archivo
            for (int i = 0; i < 10; i++) {
                //Cambio de nombre a los archivos
                String archivoSalida = nombreArchivo.replaceFirst("recursos/prueba1.pdf",

                        "Prueba" + i + ".pdf");

                System.out.println(archivoSalida);
                out = new FileOutputStream(archivoSalida);
                out.write(datos);
            }
        } finally {
            //cerrando los flujo de entrada y salida
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
