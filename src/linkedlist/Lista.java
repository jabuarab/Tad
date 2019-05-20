package linkedlist;

public interface Lista<T> {
    void add(T var1);

    void remove(int var1);

    T get(int var1);

    boolean find(T var1);

    void addFirst(T var1);

    void addLast(T var1);
}
