import sun.plugin.dom.html.ns4.NS4DOMObject;

public class MatrizForma2 {
    /*
        Hecho por Marcelo De la hoz Sierra
        CC 1037669479
     */

    private NodoDoble mat;

    public MatrizForma2(int fila, int columna) {
        Tripleta t=new Tripleta(fila,columna,null);
        mat=new NodoDoble(t);
        Tripleta tx=new Tripleta(0,0,null);
        NodoDoble x=new NodoDoble(tx);
        x.setLi(x);
        x.setLd(x);
        mat.setLd(x);
    }

    public NodoDoble primerNodo(){
        return mat;
    }

    public NodoDoble nodoCabeza(){
        return mat.getLd();
    }

    public boolean esVacia(){
        NodoDoble p=nodoCabeza();
        return (p.getLi()==p && p.getLd()==p);
    }

    public boolean finDeRecorrido(NodoDoble p){
        return p==nodoCabeza();
    }

    public String muestraMatriz(){
        String matriz="";
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q=nodoCabeza().getLd();
        while (!finDeRecorrido(q)){
            tq=(Tripleta)q.getDato();
            qf=tq.getFila();
            qc=tq.getColumna();
            qv=(Integer)tq.getValor();
            matriz+=qf+" "+qc+" "+qv+"\n";
            q=q.getLd();
        }
        return matriz;
    }

    public void conectarPorFilasForma2(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tq,tx;
        tx=(Tripleta)x.getDato();
        p=nodoCabeza();
        anterior=p;
        q=p.getLd();
        tq=(Tripleta)q.getDato();
        while (q!=p && tq.getFila()<tx.getFila()){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        while (q!=p && tq.getFila()==tx.getFila() && tq.getColumna()<tx.getColumna()){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLd(x);
        x.setLd(q);
    }

    public void conectarPorColumnasForma2(NodoDoble x){
        NodoDoble p,q,anterior;
        Tripleta tq,tx;
        tx=(Tripleta)x.getDato();
        p=nodoCabeza();
        anterior=p;
        q=p.getLi();
        tq=(Tripleta)q.getDato();
        while (q!=p && tq.getColumna()<tx.getColumna()){
            anterior=q;
            q=q.getLi();
            tq=(Tripleta)q.getDato();
        }
        while (q!=p && tq.getColumna()==tx.getColumna() && tq.getFila()<tx.getFila()){
            anterior=q;
            q=q.getLi();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLi(x);
        x.setLi(q);
    }

    public String matrizCuadrada(){
        Tripleta[] vector=new Tripleta[100];
        int c=0;
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q=nodoCabeza().getLd();
        while (!finDeRecorrido(q)){
            tq=(Tripleta)q.getDato();
            qf=tq.getFila();
            qc=tq.getColumna();
            qv=(Integer)tq.getValor();
            Tripleta t=new Tripleta(qf,qc,qv);
            vector[c]=t;
            c++;
            q=q.getLd();
        }
        Tripleta tc=(Tripleta) primerNodo().getDato();
        int fila=tc.getFila();
        int columna=tc.getColumna();
        int valor=0;
        for(int i=0;i<100;i++){
            if(vector[i]!=null){
                valor++;
            }
        }
        String matriz="";
        int k=0;
        for (int i=1;i<=fila;i++){
            for (int j=1;j<=columna;j++){
                if (k<valor && vector[k].getFila()==i && vector[k].getColumna()==j){
                    matriz+=" "+vector[k].getValor()+" ";
                    k++;
                }else{
                    matriz+=" "+0+" ";
                }
            }
            matriz+="\n";
        }
        return matriz;
    }

    public void eliminaPorFilas(int fila,int columna){
        NodoDoble p,q,anterior;
        Tripleta tq;
        p=nodoCabeza();
        anterior=p;
        q=p.getLd();
        tq=(Tripleta)q.getDato();
        while (q!=p && tq.getFila()<fila){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        while (q!=p && tq.getFila()==fila && tq.getColumna()<columna){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLd(q.getLd());
    }

    public void eliminaPorColumnas(int fila,int columna){
        NodoDoble p,q,anterior;
        Tripleta tq;
        p=nodoCabeza();
        anterior=p;
        q=p.getLi();
        tq=(Tripleta)q.getDato();
        while (q!=p && tq.getColumna()<columna){
            anterior=q;
            q=q.getLi();
            tq=(Tripleta)q.getDato();
        }
        while (q!=p && tq.getColumna()==columna && tq.getFila()<fila){
            anterior=q;
            q=q.getLi();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLi(q.getLi());
    }

    public boolean datoExiste(int fila,int columna){
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q=nodoCabeza().getLd();
        while (!finDeRecorrido(q)){
            tq=(Tripleta)q.getDato();
            qf=tq.getFila();
            qc=tq.getColumna();
            qv=(Integer)tq.getValor();
            if (qf==fila && qc==columna){
                return true;
            }
            q=q.getLd();
        }
        return false;
    }

    public int retornaFila(){
        Tripleta t=(Tripleta)primerNodo().getDato();
        return t.getFila();
    }

    public int retornaColumna(){
        Tripleta t=(Tripleta)primerNodo().getDato();
        return t.getFila();
    }

    public Tripleta[] retornaTripletas(){
        Tripleta[] lista=new Tripleta[1000];
        int k=1;
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q=nodoCabeza().getLd();
        while (!finDeRecorrido(q)){
            tq=(Tripleta)q.getDato();
            qf=tq.getFila();
            qc=tq.getColumna();
            qv=(Integer)tq.getValor();
            lista[k]=new Tripleta(qf,qc,qv);
            k++;
            q=q.getLd();
        }
        return lista;
    }

    public int retornaValor(int fila, int columna){
        int qf,qc,qv;
        NodoDoble q;
        Tripleta tq;
        q=nodoCabeza().getLd();
        while (!finDeRecorrido(q)){
            tq=(Tripleta)q.getDato();
            qf=tq.getFila();
            qc=tq.getColumna();
            qv=(Integer)tq.getValor();
            if (qf==fila && qc==columna){
                return qv;
            }
            q=q.getLd();
        }
        return 0;
    }
}
