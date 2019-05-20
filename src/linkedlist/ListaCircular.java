package linkedlist;

public class ListaCircular<Q> implements Lista<Q> {
    private Nodo<Q> oFirst;
    private Nodo<Q> oLast;
    private int size;

    public ListaCircular() {
    }

    public void add(Q value) {
        Nodo<Q> nuevo = new Nodo(value);
        if (this.oFirst == null) {
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
            this.oLast.setSiguiente(this.oFirst);
            this.oFirst.setAnterior(this.oLast);
        }

        ++this.size;
    }

    public void remove(int position) throws IndexOutOfBoundsException {
        if (position >= this.getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (this.getSize() == 1) {
                this.oLast = null;
                this.oFirst = null;
            } else {
                Nodo<Q> temp = this.oFirst;
                if (position == 0) {
                    temp = temp.getSiguiente();
                    this.oFirst = temp;
                    this.oFirst.setAnterior(this.oLast);
                    this.oLast.setSiguiente(this.oFirst);
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
    }

    public Q get(int position) throws IndexOutOfBoundsException {
        if (position > this.getSize()) {
            throw new IndexOutOfBoundsException();
        } else {
            Nodo<Q> temp = this.oFirst;

            for(int i = 1; i <= position; ++i) {
                temp = temp.getSiguiente();
            }

            Q result = temp.getValue();
            return result;
        }
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
        } while(temp != null && i < this.getSize());

        return result;
    }

    public void shift(int position) throws IndexOutOfBoundsException {
        Nodo<Q> temp = this.oFirst;

        for(int i = 1; i <= position; ++i) {
            temp = temp.getSiguiente();
        }

        this.oFirst = temp;
        this.oLast = this.oFirst.getAnterior();
    }

    public void addFirst(Q value) throws NoSuchMethodError {
    }

    public void addLast(Q value) throws NoSuchMethodError {
    }

    public int getSize() {
        return this.size;
    }
}
