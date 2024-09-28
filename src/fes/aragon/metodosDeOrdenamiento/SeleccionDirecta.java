package fes.aragon.metodosDeOrdenamiento;
import fes.aragon.dinamico.ListaDoble;
import fes.aragon.dinamico.Nodo;
import fes.aragon.dinamico.NodoDoble;

public class SeleccionDirecta {
    public static void main(String[] args) {

        int[] pruebas = {15, 67, 8, 16, 44, 27, 12, 35};

        int menor, k;

        for (int i = 0; i < pruebas.length; i++) {
            menor = pruebas[i];
            k = i;
            for (int j = i + 1; j < pruebas.length; j++) {
                if (pruebas[j] < menor) {
                    menor = pruebas[j];
                    k = j;
                }
            }
            pruebas[k] = pruebas[i];
            pruebas[i] = menor;
        }
        for (int g = 0; g < pruebas.length; g++) {
            System.out.println(pruebas[g]);
        }
        System.out.println("***************************************************************************************************");

        ListaDoble<Integer> AlistaDoble = new ListaDoble<>();
        int[] pruebasDoble = {15, 67, 8, 16, 44, 27, 12, 35};
        for (int valor : pruebasDoble) {
            AlistaDoble.agregarEnCola(valor);
        }

        System.out.println("Lista antes de ordenar:");
        AlistaDoble.imprimirElementos();

        NodoDoble<Integer> actual = AlistaDoble.getCabeza();

        while (actual != null) {
            NodoDoble<Integer> Amenor = actual;
            NodoDoble<Integer> siguiente = actual.getSiguiente();

            while (siguiente != null) {
                if (siguiente.getDato().compareTo(Amenor.getDato()) < 0) {
                    Amenor = siguiente;
                }
                siguiente = siguiente.getSiguiente();
            }
            // Intercambiar los valores
            if (Amenor != actual) {
                Integer temp = actual.getDato();
                actual.setDato(Amenor.getDato());
                Amenor.setDato(temp);
            }

            actual = actual.getSiguiente();
        }


        System.out.println("Lista después de ordenar:");
        AlistaDoble.imprimirElementos();
        System.out.println("---");
    }
}
