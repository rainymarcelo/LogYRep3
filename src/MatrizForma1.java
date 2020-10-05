import org.omg.CORBA.NO_IMPLEMENT;

public class MatrizForma1 {
    /*
        Hecho por Marcelo De la hoz Sierra
        CC 1037669479
         */

    private NodoDoble mat;

    public MatrizForma1(int fila, int columna) {
        Tripleta t = new Tripleta(fila, columna, null);
        mat = new NodoDoble(t);
        t.setValor(mat);
        mat.setDato(t);
    }//funciona

    public NodoDoble nodoCabeza() {
        return mat;
    }//funciona

    public NodoDoble primerNodo() {
        Tripleta tp = (Tripleta) mat.getDato();
        NodoDoble p = (NodoDoble) tp.getValor();
        return p;
    }//funciona

    public boolean esVacia() {
        NodoDoble p = primerNodo();
        return p == mat;
    }//

    public boolean finDeRecorrido(NodoDoble p) {
        return p == mat;
    }//funciona

    public String muestraMatriz() {
        String matriz = "";
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tp, tq;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            q = p.getLd();
            while (q != p) {
                tq = (Tripleta) q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (Integer) tq.getValor();
                matriz += qf + " " + qc + " " + qv + "\n";
                q = q.getLd();
            }
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        return matriz;
    }//funciona

    public void contruyeNodosCabeza() {
        int mayor, m, n;
        NodoDoble x, ultimo;
        Tripleta t;
        ultimo = nodoCabeza();
        t = (Tripleta) ultimo.getDato();
        m = t.getFila();
        n = t.getColumna();
        mayor = m;
        if (n > m) {
            mayor = n;
        }
        for (int i = 1; i <= mayor; i++) {
            t = new Tripleta(i, i, nodoCabeza());
            x = new NodoDoble(t);
            x.setLd(x);
            x.setLi(x);
            t = (Tripleta) ultimo.getDato();
            t.setValor(x);
            ultimo.setDato(t);
            ultimo = x;
        }
    }//funciona

    public void conectaPorFila(NodoDoble x) {
        NodoDoble p,q,anterior;
        Tripleta tp,tq,tx;
        tx=(Tripleta)x.getDato();
        p=primerNodo();
        for (int i=1;i<tx.getFila();i++){
            tp=(Tripleta)p.getDato();
            p=(NodoDoble)tp.getValor();
        }
        anterior=p;
        q=p.getLd();
        tq=(Tripleta)q.getDato();
        while ((q!=p) && (tq.getColumna()<tx.getColumna())){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLd(x);
        x.setLd(q);
    }

    public void conectaPorColumna(NodoDoble x) {
        NodoDoble p, q, anterior;
        Tripleta tp, tq, tx;
        tx = (Tripleta) x.getDato();
        p = primerNodo();
        for (int i = 1; i < tx.getColumna(); i++) {
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        anterior = p;
        q = p.getLi();
        tq = (Tripleta) q.getDato();
        while ((q != p) && (tq.getFila() < tx.getFila())) {
            anterior = q;
            q = q.getLi();
            tq = (Tripleta) q.getDato();
        }
        anterior.setLi(x);
        x.setLi(q);
    }//funciona

    public String matrizCuadrada() {
        Tripleta[] vector = new Tripleta[100];
        int c = 0;
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tp, tq;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            q = p.getLd();
            while (q != p) {
                tq = (Tripleta) q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (Integer) tq.getValor();
                Tripleta t = new Tripleta(qf, qc, qv);
                vector[c] = t;
                c++;
                q = q.getLd();
            }
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        Tripleta tc = (Tripleta) nodoCabeza().getDato();
        int fila = tc.getFila();
        int columna = tc.getColumna();
        int valor = 0;
        for (int i = 0; i < 100; i++) {
            if (vector[i] != null) {
                valor++;
            }
        }
        String matriz = "";
        int k = 0;
        for (int i = 1; i <= fila; i++) {
            for (int j = 1; j <= columna; j++) {
                if (k < valor && vector[k].getFila() == i && vector[k].getColumna() == j) {
                    matriz += " " + vector[k].getValor() + " ";
                    k++;
                } else {
                    matriz += " " + 0 + " ";
                }
            }
            matriz += "\n";
        }
        return matriz;
    }

    public void eliminarDatofila(int fila,int columna){
        NodoDoble p,q,anterior;
        Tripleta tp,tq,tx;
        p=primerNodo();
        for (int i=1;i<fila;i++){
            tp=(Tripleta)p.getDato();
            p=(NodoDoble)tp.getValor();
        }
        anterior=p;
        q=p.getLd();
        tq=(Tripleta)q.getDato();
        while ((q!=p) && (tq.getColumna()<columna)){
            anterior=q;
            q=q.getLd();
            tq=(Tripleta)q.getDato();
        }
        anterior.setLd(q.getLd());
    }

    public void  eliminarDatoColumna(int fila,int columna){
        NodoDoble p, q, anterior;
        Tripleta tp, tq, tx;
        p = primerNodo();
        for (int i = 1; i <columna; i++) {
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        anterior = p;
        q = p.getLi();
        tq = (Tripleta) q.getDato();
        while ((q != p) && (tq.getFila() < fila)) {
            anterior = q;
            q = q.getLi();
            tq = (Tripleta) q.getDato();
        }
        anterior.setLi(q.getLi());
    }

    public boolean datoExiste(int fila, int columna){
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tp, tq;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            q = p.getLd();
            while (q != p) {
                tq = (Tripleta) q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (Integer) tq.getValor();
                if (qf==fila && qc==columna){
                    return true;
                }
                q = q.getLd();
            }
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        return  false;
    }

    public int retornafila(){
        Tripleta t=(Tripleta)nodoCabeza().getDato();
        return t.getFila();
    }

    public int retornaColumna(){
        Tripleta t=(Tripleta)nodoCabeza().getDato();
        return t.getColumna();
    }

    public Tripleta[] retornaTripletas(){
        Tripleta[] lista=new Tripleta[1000];
        int k=1;
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tp, tq;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            q = p.getLd();
            while (q != p) {
                tq = (Tripleta) q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (Integer) tq.getValor();
                lista[k]=new Tripleta(qf,qc,qv);
                k++;
                q = q.getLd();
            }
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        return lista;
    }

    public int retornaValor(int fila, int columna){
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tp, tq;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            q = p.getLd();
            while (q != p) {
                tq = (Tripleta) q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (Integer) tq.getValor();
                if (qf==fila && qc==columna){
                    return qv;
                }
                q = q.getLd();
            }
            tp = (Tripleta) p.getDato();
            p = (NodoDoble) tp.getValor();
        }
        return 0;
    }

    public MatrizForma2 sumaForma1YForma2ResultadoForma2(MatrizForma2 mf2){
        MatrizForma2 matrizForma2=new MatrizForma2(retornafila(),retornaColumna());
        Tripleta[] tmf1=retornaTripletas();
        for (int i=1;i<tmf1.length;i++){
            if (tmf1[i]!=null){
                int fila=tmf1[i].getFila();
                int columna=tmf1[i].getColumna();
                int valor=(Integer)tmf1[i].getValor();
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
    //para crear la traspuesta solo ahi que cambiar los metodos contruye nodo cabeza linea 61 el lado de la desigualdad
    //y en conecta fila y columnas la coneccion de los Ld  a Li y viceversa
}
