package fes.aragon.dinamico;

public class ListaSimple {
    Nodo cabeza;
    Nodo cola;
    Integer longitud=0;

    public ListaSimple(Integer dato){
        cabeza=new Nodo(dato);
        this.cola=cabeza;
        longitud++;
        System.out.println(+longitud);
        System.out.println(""+cabeza);
        System.out.println(""+cola);
        System.out.println(+dato);
    }
}
