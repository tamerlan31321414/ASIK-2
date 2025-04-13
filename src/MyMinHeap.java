public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.addLast(item);
        heapifyUp();
    }

    public T extractMin() {
        if (heap.size() == 0) return null;
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.removeLast();
        heapifyDown();
        return min;
    }

    public T peek() {
        if (heap.size() == 0) return null;
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) >= 0) break;

            T temp = current;
            heap.set(index, parent);
            heap.set(parentIndex, temp);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            T temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
            index = smallest;
        }
    }
}