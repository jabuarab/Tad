package linkedlist;


public class Nodo<T> {
    private T value;
    private Nodo<T> oSig;
    private Nodo<T> oAnt;

    public Nodo(T value) {
        this.value = value;
    }

    public void setSiguiente(Nodo oSig) {
        this.oSig = oSig;
    }

    public void setAnterior(Nodo oAnt) {
        this.oAnt = oAnt;
    }

    public Nodo getSiguiente() {
        return this.oSig;
    }

    public Nodo getAnterior() {
        return this.oAnt;
    }

    public T getValue() {
        return this.value;
    }
}
