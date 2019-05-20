package linkedlist;

public class ListaEnlazada<Q> implements Lista<Q> {
    private Nodo<Q> oFirst;
    private Nodo<Q> oLast;
    private int size = 0;

    public ListaEnlazada() {
    }

    public void add(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.size == 0) {
            this.oFirst = nuevo;
            this.oLast = nuevo;
        } else if (this.oFirst.getSiguiente() == null) {
            this.oLast = nuevo;
            this.oFirst.setSiguiente(this.oLast);
        } else {
            this.oLast.setSiguiente(nuevo);
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
            } else {
                for(int i = 0; i < position - 1; ++i) {
                    temp = temp.getSiguiente();
                }

                Nodo temp2 = temp.getSiguiente();
                temp.setSiguiente(temp2.getSiguiente());
                temp2.setSiguiente((Nodo)null);
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
        int counter = 0;

        do {
            if (temp.getValue().equals(value)) {
                result = true;
            } else {
                temp = temp.getSiguiente();
            }

            ++counter;
        } while(counter < this.getSize());

        return result;
    }

    public void addFirst(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.oFirst == null) {
            this.add(value);
        } else {
            nuevo.setSiguiente(this.oFirst);
            this.oFirst = nuevo;
        }

    }

    public void addLast(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.oFirst.getSiguiente() == null) {
            this.oFirst.setSiguiente(nuevo);
            this.oLast = nuevo;
        } else {
            this.oLast.setSiguiente(nuevo);
            this.oLast = nuevo;
        }

    }

    public int getSize() {
        return this.size;
    }
}