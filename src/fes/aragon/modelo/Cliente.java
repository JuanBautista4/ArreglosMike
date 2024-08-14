package fes.aragon.modelo;

public class Cliente {
    public int indice;
    private int posi;


public void cliente(){

}

    public void insertar(int valor, int[] a) {
        System.out.println("insertar funciona");
        if(!validarLongitud(a)){
            a[indice]=valor;
            System.out.println(valor+"<---- valor agregado");
            indice++;
        }
    }


    private boolean validarLongitud(int[]a){
        boolean limite=false;
        System.out.println("validar funciona");
        if(indice==a.length){
            limite=true;
        }
        return limite;
    }

    public int localizar(int[]a, int x){
        int pos=0;
        System.out.println("localizar funciona");
        for(int i=0; i<a.length;i++){
            if(a[i]==x){
                pos=i;
                System.out.println(pos+ "<---- posicion");
            }
            else{
                pos=(-1);
            }
        }
        return pos;
    }

    public boolean validarPosicion(int[]a){
        boolean posicion=false;
        if(posi<a.length){
            posicion=true;
        }
        return posicion;
    }
    public int recuperar(int[]a, int p){
        int val = 0;
        if(validarPosicion(a)) {
            System.out.println("recuperar funciona");
            for(int i=0; i<a.length;i++){
                if(p==i){
                    val=a[p];

                }
            }
        }
        System.out.println(val+ "<---- Recuperado");
        return val;
    }
    public void suprimir(int[]a,int p){
        System.out.println(a[p]+"<----antes de restablecer");
        for (int i = 0; i < a.length; i++) {
                if(i==p){
                    a[i]=0;
                    System.out.println(a[i]+"<----Se restablece a 0");
                }
        }
    }
}
