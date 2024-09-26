package fes.aragon.ficheros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopiarBytes3 {
    public static void main(String[] args) {
        try {
            CopiarBytes3 cp = new CopiarBytes3();
            cp.copiarArchivo();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void copiarArchivo() throws IOException {
        //clase para el flujo de entrada
        FileInputStream in = null;
        //clase para el flujo de salida
        FileOutputStream out = null;
        try {
            String nombreArchivo = "/home/juanpi/Escritorio/prueba1.pdf";
            //Ubicación del archivo
            in = new FileInputStream(nombreArchivo);
            int numeroArchivos=5;
            byte[] datos = new byte[in.available()];
            in.read(datos);
            int numeroBytes = (datos.length / numeroArchivos);
            int contador = 0;
            int indiceArchivo = 1;
            while (contador < datos.length) {
                String archivoSalida =

                        nombreArchivo.replaceFirst("/home/juanpi/Escritorio/prueba1.pdf", "Prueba"

                                + indiceArchivo + ".pdf");
                out = new FileOutputStream(archivoSalida);
                out.write(datos, contador, numeroBytes);
                contador += (numeroBytes);
                indiceArchivo++;
                if (indiceArchivo==numeroArchivos) {
                    numeroBytes=datos.length-contador;
                }
            }
            out = new FileOutputStream("/home/juanpi/Escritorio/prueba.pdf");
            for (int i = 1; i <=numeroArchivos ; i++) {
                String archivoEntrada = nombreArchivo.replaceFirst("/home/juanpi/Escritorio/prueba.pdf", "Prueba"
                                + i + ".pdf");
                in = new FileInputStream(archivoEntrada);
                System.out.println("Archivo: " + i + " " + in.available());

                byte[] datosEntrada = new byte[in.available()];
                in.read(datosEntrada);
                out.write(datosEntrada);
            }
            System.out.println("Salida:" + out.getChannel().size());
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
