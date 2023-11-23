package homework9;

public class MyQueue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (front == null) {
            return null;
        }
        return front.getValue();
    }

    public T poll() {
        if (front == null) {
            return null;
        }

        T value = front.getValue();
        front = front.getNext();
        size--;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

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
    }
}
