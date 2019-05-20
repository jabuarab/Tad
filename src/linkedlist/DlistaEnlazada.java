package linkedlist;

public class DListaEnlazada<Q> implements Lista<Q> {
    private Nodo<Q> oFirst;
    private Nodo<Q> oLast;
    private int size = 0;

    public DListaEnlazada() {
    }

    public void add(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.size == 0) {
            this.oFirst = nuevo;
            this.oLast = nuevo;
        } else if (this.oFirst.getSiguiente() == null) {
            this.oLast = nuevo;
            this.oLast.setAnterior(this.oFirst);
            this.oFirst.setSiguiente(this.oLast);
        } else {
            this.oLast.setSiguiente(nuevo);
            nuevo.setAnterior(this.oLast);
            this.oLast = nuevo;
        }

        ++this.size;
    }

    public void remove(int position) {
        if (this.oFirst.getSiguiente() == null && position == 0) {
            this.oLast = null;
            this.oFirst = null;
        } else {
            Nodo<Q> temp = this.oFirst;
            if (position == 0) {
                temp = temp.getSiguiente();
                this.oFirst = temp;
            } else if (position == this.getSize() - 1) {
                this.oLast = this.oLast.getAnterior();
                this.oLast.setSiguiente((Nodo)null);
            } else {
                for(int i = 0; i < position; ++i) {
                    temp = temp.getSiguiente();
                }

                temp.getAnterior().setSiguiente(temp.getSiguiente());
                temp.getSiguiente().setAnterior(temp.getAnterior());
                temp.setAnterior((Nodo)null);
                temp.setSiguiente((Nodo)null);
            }
        }

        --this.size;
    }

    public Q get(int position) {
        Nodo<Q> temp = this.oFirst;

        for(int i = 1; i <= position; ++i) {
            temp = temp.getSiguiente();
        }

        Q result = temp.getValue();
        return result;
    }

    public boolean find(Q value) {
        boolean result = false;
        Nodo<Q> temp = this.oFirst;
        int i = 0;

        do {
            if (temp.getValue().equals(value)) {
                result = true;
            } else {
                temp = temp.getSiguiente();
            }

            ++i;
        } while(i < this.getSize());

        return result;
    }

    public void addFirst(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.oFirst == null) {
            this.add(value);
        } else {
            nuevo.setSiguiente(this.oFirst);
            this.oFirst.setAnterior(nuevo);
            this.oFirst = nuevo;
        }

    }

    public void addLast(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.oFirst == null) {
            this.add(value);
        } else if (this.oFirst.getSiguiente() == null) {
            this.oFirst.setSiguiente(nuevo);
            nuevo.setAnterior(this.oFirst);
            this.oLast = nuevo;
        } else {
            this.oLast.setSiguiente(nuevo);
            nuevo.setAnterior(this.oLast);
            this.oLast = nuevo;
        }

    }

    public int getSize() {
        return this.size;
    }

    public Nodo<Q> getLast() {
        return this.oLast;
    }

    public Nodo<Q> getFirst() {
        return this.oFirst;
    }
}
