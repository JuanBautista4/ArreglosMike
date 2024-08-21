package fes.aragon.estatico;
import fes.aragon.estatico.Arreglo;
import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.modelo.Cliente;

import java.io.IOException;


    public class Inicio {
        public static void main(String[] args) throws IndiceFueraDeRango {

            Arreglo<Double> generico=new Arreglo<>(5);
            generico.insertar(19.0);
            generico.insertar(15.0);
            generico.insertar(13.0);
            generico.insertar(12.0);
            generico.insertar(11.0);
            System.out.println(generico.recupera(3));
            System.out.println(generico.localiza(15.0));
            System.out.println(generico.anterior(3));
            System.out.println(generico.siguiente(3));
            generico.suprime(3);
            System.out.println(generico.recupera(3));
            try{
                generico.insertar(19.0);
                generico.insertar(15.0);
                generico.insertar(13.0);
                generico.insertar(12.0);
                generico.insertar(11.0);
                for(int i=0; i<5; i++){
                    System.out.println(generico.recupera(i));

                }
            }catch (IndiceFueraDeRango e){
                System.out.println("Error al introducir datos");
            }
            generico.limpiar();
            generico.recupera(2);
        }
    }


