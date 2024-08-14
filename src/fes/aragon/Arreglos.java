package fes.aragon;

import fes.aragon.modelo.Cliente;


public class Arreglos {
    public static void main(String[] args) {
        System.out.println("hola");
        int[] arreglo=new int[10];
        Cliente metodos = new Cliente();
        metodos.insertar(20,arreglo);
        metodos.insertar(10,arreglo);
        metodos.insertar(40,arreglo);
        metodos.insertar(60,arreglo);
        metodos.insertar(30,arreglo);
        metodos.insertar(50,arreglo);
        metodos.insertar(90,arreglo);
        metodos.insertar(70,arreglo);
        metodos.insertar(100,arreglo);
        metodos.insertar(80,arreglo);
        metodos.localizar(arreglo,100);
        metodos.localizar(arreglo,70);
        metodos.recuperar(arreglo,8);
        metodos.suprimir(arreglo,2);
        metodos.anterior(arreglo,2);


    }
}
