public class Tripleta {
    private int columna,fila;
    Object valor;

    public Tripleta(int fila,int columna , Object valor) {
        this.columna = columna;
        this.fila = fila;
        this.valor = valor;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
