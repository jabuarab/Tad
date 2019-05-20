package Hash;

public class Nodo<T,K> {
    private T value;
    private K key;
    private Nodo<T,K> oSig;
    private Nodo<T,K> oAnt;

    public Nodo(T value,K key) {
        this.value = value;
        this.key = key;
    }

    public Nodo<T, K> getoSig() {
        return oSig;
    }

    public void setSiguiente(Nodo<T, K> oSig) {
        this.oSig = oSig;
    }

    public Nodo<T, K> getoAnt() {
        return oAnt;
    }

    public void setAnterior(Nodo<T, K> oAnt) {
        this.oAnt = oAnt;
    }

    public K getKey() {
        return key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }


    public T getValue() {
        return this.value;
    }
}
