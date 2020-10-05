public class NodoDoble {
    private Object dato;
    private NodoDoble Li,Ld;

    public NodoDoble(Object dato) {
        this.dato = dato;
        Li = null;
        Ld = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getLi() {
        return Li;
    }

    public void setLi(NodoDoble li) {
        Li = li;
    }

    public NodoDoble getLd() {
        return Ld;
    }

    public void setLd(NodoDoble ld) {
        Ld = ld;
    }
}
