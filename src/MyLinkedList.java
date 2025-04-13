public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void set(int index, T item) {
        Node node = getNode(index);
        if (node != null) node.data = item;
    }

    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node node = getNode(index);
        if (node == null) return;
        Node newNode = new Node(item);
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev.next = newNode;
        node.prev = newNode;
        size++;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node node = getNode(index);
        return node != null ? node.data : null;
    }

    public T getFirst() {
        return head != null ? head.data : null;
    }

    public T getLast() {
        return tail != null ? tail.data : null;
    }

    public void remove(int index) {
        Node node = getNode(index);
        if (node != null) removeNode(node);
    }

    public void removeFirst() {
        if (head != null) removeNode(head);
    }

    public void removeLast() {
        if (tail != null) removeNode(tail);
    }

    public void sort() {
        // Not implemented for now (student with basic knowledge)
    }

    public int indexOf(Object object) {
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.data.equals(object)) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        Node current = tail;
        int i = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return i;
            current = current.prev;
            i--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }
}
