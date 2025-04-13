public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (list.size() == 0) return null;
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (list.size() == 0) return null;
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
