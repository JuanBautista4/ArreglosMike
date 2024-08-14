package fes.aragon;

import fes.aragon.modelo.Cliente;


public class Arreglos {
    public static void main(String[] args) {
        System.out.println("hola");
        int[] arreglo=new int[10];
        Cliente metodos = new Cliente();
        metodos.insertar(20,arreglo);
        metodos.insertar(10,arreglo);
metodos.localizar(arreglo,20);
metodos.recuperar(arreglo,0);
    }
}
