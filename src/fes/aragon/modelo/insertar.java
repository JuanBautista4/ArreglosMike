package fes.aragon.modelo;

public class insertar {
    private int indice;
    private int posi;

    public insertar(int valor, int[] a) {
        if(!validarLongitud(a)){
            a[indice]=valor;
            indice++;
        }
    }


    private boolean validarLongitud(int[]a){
        boolean limite=false;
        if(indice==a.length){
            limite=true;
        }
        return limite;
//juan puto
    }

    public int localizar(int[]a, int x){
        int pos=0;
        for(int i=0; i<a.length;i++){
            if(a[i]==x){
                pos=i;
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
            for(int i=0; i<a.length;i++){
                if(p==i){
                    return val;
                }
            }
        }
        return val;
    }
}
