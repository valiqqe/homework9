package homework9;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = getNode(index);

        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        } else {
            head = current.getNext();
        }

        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
        } else {
            tail = current.getPrevious();
        }

        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}