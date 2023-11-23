package homework9;

public class MyStack<T> {

    private Node<T> top;
    private int size;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            top = top.getNext();
        } else {
            Node<T> current = top;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            current.setNext(current.getNext().getNext());
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }

    public T pop() {
        if (top == null) {
            return null;
        }

        T value = top.getValue();
        top = top.getNext();
        size--;

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
