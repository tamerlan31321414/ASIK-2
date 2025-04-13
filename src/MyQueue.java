public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0) return null;
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (list.size() == 0) return null;
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}