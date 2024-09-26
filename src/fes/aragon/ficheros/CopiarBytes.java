package fes.aragon.ficheros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopiarBytes {
    public static void main(String[] args) {
        try {
            CopiarBytes cp = new CopiarBytes();
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
            //Ubicación del archivo
            in = new FileInputStream("/home/juanpi/Escritorio/prueba1.pdf");
            //Salida del Archivo
            out = new FileOutputStream("/home/juanpi/Escritorio/Prueba.pdf");
            int c;
            //lectura del flujo de bytes hasta que nos proporcionen -1
            while ((c = in.read()) != -1) {
                //escribiendo el flujo de bytes
                System.out.println("Entero: "+ c +
                        " Binario: " + Integer.toBinaryString(c)+
                        " Octal: " + Integer.toOctalString(c) +
                        " Hexadecimal: " + Integer.toHexString(c));
                out.write(c);
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
