public class MyArrayList<T> implements MyList<T> {
    private Object[] a;
    private int n;

    public MyArrayList() {
        a = new Object[10];
        n = 0;
    }

    private void grow() {
        Object[] temp = new Object[a.length * 2];
        for (int i = 0; i < n; i++) temp[i] = a[i];
        a = temp;
    }

    public void add(T item) {
        if (n == a.length) {
            grow();
        }
        a[n] = item;
        n++;
    }

    public void add(int idx, T item) {
        if (idx < 0 || idx > n) return;
        if (n >= a.length) grow();
        for (int i = n; i > idx; i--) {
            a[i] = a[i - 1];
        }
        a[idx] = item;
        n++;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(t);
    }

    public T get(int i) {
        if (i < 0 || i >= n) return null;
        return (T) a[i];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(n - 1);
    }

    public void set(int i, T t) {
        if (i >= 0 && i < n) {
            a[i] = t;
        }
    }

    public void remove(int i) {
        if (i < 0 || i >= n) return;
        for (int j = i; j < n - 1; j++) {
            a[j] = a[j + 1];
        }
        a[n - 1] = null;
        n--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(n - 1);
    }

    public void clear() {
        for (int i = 0; i < n; i++) {
            a[i] = null;
        }
        n = 0;
    }

    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < n; i++) {
            if (a[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = n - 1; i >= 0; i--) {
            if (a[i].equals(o)) return i;
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[n];
        for (int i = 0; i < n; i++) arr[i] = a[i];
        return arr;
    }

    public void sort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Comparable<T> x = (Comparable<T>) a[j];
                T y = (T) a[j + 1];
                if (x.compareTo(y) > 0) {
                    Object tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public int size() {
        return n;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int k = 0;
            public boolean hasNext() {
                return k < n;
            }
            public T next() {
                return (T) a[k++];
            }
        };
    }
}
