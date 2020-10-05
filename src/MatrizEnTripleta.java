import org.omg.PortableInterceptor.INACTIVE;

public class MatrizEnTripleta {
    /*
        Hecho por Marcelo De la hoz Sierra
        CC 1037669479
         */

    private Tripleta[] vector = new Tripleta[1000];

    public MatrizEnTripleta(Tripleta t) {
        vector[0] = t;
    }//funciona

    public void InsertarTripleta(Tripleta ti) {
        int i,j,p;
        Tripleta t;
        p=(Integer) vector[0].getValor();
        i=1;
        t=vector[i];
        while (i<=p && t.getFila()<ti.getFila()){
            i+=1;
            t=vector[i];
        }
        while (i<=p && t.getFila()==ti.getFila() && t.getColumna()<=ti.getColumna()){
            i+=1;
            t=vector[i];
        }
        p=p+1;
        j=p-1;
        while (j>=i){
            vector[j+1]=vector[j];
            j=j-1;
        }
        vector[i]=ti;
        vector[0].setValor(p);
    }//funiciona

    public MatrizEnTripleta Traspuesta() {
        int i,p,f,c,v;
        Tripleta ti;
        p=(Integer)vector[0].getValor();
        ti=new Tripleta(vector[0].getColumna(),vector[0].getFila(),0);
        MatrizEnTripleta b=new MatrizEnTripleta(ti);
        i=1;
        while (i<=p){
            ti=vector[i];
            f=ti.getColumna();
            c=ti.getFila();
            v=(Integer)ti.getValor();
            ti=new Tripleta(f,c,v);
            b.InsertarTripleta(ti);
            i=i+1;
        }
        return b;
    }//funciona

    public void AsignaTripleta(Tripleta t, int k) {
        vector[k] = t;
    }

    public String MostrarMatriz() {
        String matriz="";
        int k=1;
        for (int i=1;i<=vector[0].getFila();i++){
            for (int j=1;j<=vector[0].getColumna();j++){
                if (k<=(Integer)vector[0].getValor() && vector[k].getFila()==i && vector[k].getColumna()==j){
                    matriz+=" "+vector[k].getValor().toString()+" ";
                    k++;
                }
                else {
                    matriz+=" "+0+" ";
                }
            }
            matriz+="\n";
        }
        return matriz;
    }//funciona

    public String mostrarMatrizTripleta(){
        String matriz="";
        int p=(Integer)vector[0].getValor();
        for (int i=1;i<=p;i++){
            matriz+=vector[i].getFila()+" "+vector[i].getColumna()+" "+vector[i].getValor().toString()+"\n";
        }
        return matriz;
    }//funciona

    public void eliminarTripleta(int fila,int columna){
        int f=vector[0].getFila();
        int c=vector[0].getColumna();
        int p=(Integer) vector[0].getValor();
        int k=0;
        if (!(f<fila) || !(c<columna)){
            for (int i=1;i<=p;i++){
                if (fila==vector[i].getFila() && columna==vector[i].getColumna()){
                    k=i;
                }
            }
        }
        while (k<=p){
            vector[k]=vector[k+1];
            k++;
        }
        vector[0].setValor(p-1);
    }

    public boolean datoExiste(int fila,int columna){
        int k=1;
        int p=(Integer) vector[0].getValor();
        while (k<=p){
            int f=vector[k].getFila();
            int c=vector[k].getColumna();
            if (fila==f && columna==c){
                return true;
            }
            k++;
        }
        return false;
    }

    public int retornaFila(){
        return vector[0].getFila();
    }

    public int retornaColumna(){
        return vector[0].getColumna();
    }

    public MatrizForma2 sumaConForma1RetornaForma2(MatrizForma1 mf1){
        MatrizForma2 matrizForma2=new MatrizForma2(retornaFila(),retornaColumna());
        for (int i=1;i<=(Integer) vector[0].getValor();i++){
            int fila=vector[i].getFila();
            int columna=vector[i].getColumna();
            int valor=(Integer) vector[i].getValor();
            if (mf1.datoExiste(fila,columna)){
                int valorf1=mf1.retornaValor(fila,columna);
                Tripleta tripleta=new Tripleta(fila,columna,valor+valorf1);
                NodoDoble x=new NodoDoble(tripleta);
                matrizForma2.conectarPorFilasForma2(x);
                matrizForma2.conectarPorColumnasForma2(x);
            }else {
                Tripleta tripleta=new Tripleta(fila,columna,valor);
                NodoDoble x=new NodoDoble(tripleta);
                matrizForma2.conectarPorFilasForma2(x);
                matrizForma2.conectarPorColumnasForma2(x);
            }
        }
        Tripleta[] tmf1=mf1.retornaTripletas();
        for (int i=1;i<tmf1.length;i++){
            if (tmf1[i]!=null){
                int fila=tmf1[i].getFila();
                int columna=tmf1[i].getColumna();
                int valor=(Integer) tmf1[i].getValor();
                if (!datoExiste(fila,columna)){
                    Tripleta tripleta=new Tripleta(fila,columna,valor);
                    NodoDoble x= new NodoDoble(tripleta);
                    matrizForma2.conectarPorFilasForma2(x);
                    matrizForma2.conectarPorColumnasForma2(x);
                }
            }
        }
        return matrizForma2;
    }

    public MatrizForma2 sumaConForma2RetornaForma2(MatrizForma2 mf2){
        MatrizForma2 matrizForma2=new MatrizForma2(retornaFila(),retornaColumna());
        for (int i=1;i<=(Integer) vector[0].getValor();i++){
            int fila=vector[i].getFila();
            int columna=vector[i].getColumna();
            int valor=(Integer) vector[i].getValor();
            if (mf2.datoExiste(fila,columna)){
                int valorf1=mf2.retornaValor(fila,columna);
                Tripleta tripleta=new Tripleta(fila,columna,valor+valorf1);
                NodoDoble x=new NodoDoble(tripleta);
                matrizForma2.conectarPorFilasForma2(x);
                matrizForma2.conectarPorColumnasForma2(x);
            }else {
                Tripleta tripleta=new Tripleta(fila,columna,valor);
                NodoDoble x=new NodoDoble(tripleta);
                matrizForma2.conectarPorFilasForma2(x);
                matrizForma2.conectarPorColumnasForma2(x);
            }
        }
        Tripleta[] tmf2=mf2.retornaTripletas();
        for (int i=1;i<tmf2.length;i++){
            if (tmf2[i]!=null){
                int fila=tmf2[i].getFila();
                int columna=tmf2[i].getColumna();
                int valor=(Integer) tmf2[i].getValor();
                if (!datoExiste(fila,columna)){
                    Tripleta tripleta=new Tripleta(fila,columna,valor);
                    NodoDoble x= new NodoDoble(tripleta);
                    matrizForma2.conectarPorFilasForma2(x);
                    matrizForma2.conectarPorColumnasForma2(x);
                }
            }
        }
        return matrizForma2;
    }
}
