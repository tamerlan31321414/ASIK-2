public interface MyList<T> {
    void add(T value);
    void add(int pos, T value);

    void addFirst(T value);
    void addLast(T value);

    T get(int index);
    T getFirst();
    T getLast();

    void set(int index, T value);

    void remove(int index);
    void removeFirst();
    void removeLast();

    int indexOf(Object val);
    int lastIndexOf(Object val);
    boolean exists(Object val);

    Object[] toArray();

    void clear();
    int size();

    java.util.Iterator<T> iterator();
}
