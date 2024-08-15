package fes.aragon;

import fes.aragon.estatico.Arreglo;
import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.modelo.Cliente;


public class Arreglos {
    public static void main(String[] args) throws IndiceFueraDeRango {
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
        metodos.siguiente(arreglo,8);
        metodos.anterior(arreglo,2);
        Arreglo<Integer> generico=new Arreglo<>(5);
        generico.insertar(19);
        generico.insertar(15);
        generico.insertar(13);
        generico.insertar(12);
        generico.insertar(11);
        System.out.println(generico.recupera(3));
        System.out.println(generico.localiza(15));
        System.out.println(generico.anterior(3));
        System.out.println(generico.siguiente(3));
        generico.suprime(3);
        System.out.println(generico.recupera(3));

    }
}
