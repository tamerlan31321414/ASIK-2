public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);

    T get(int index);
    T getFirst();
    T getLast();

    void set(int index, T item);

    void remove(int index);
    void removeFirst();
    void removeLast();

    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);

    Object[] toArray();
    void clear();
    int size();

    java.util.Iterator<T> iterator();
}
