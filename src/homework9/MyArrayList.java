package homework9;

public class MyArrayList<T> {

    private Object[] values = new Object[10];

    private int size = 0;

    public void add(T obj) {
        rebalance();
        values[size] = obj;
        size++;
    }

    public T get(int index) {

        return (T) values[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }

        size--;
        values[size] = null;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private void rebalance() {
        if (values.length == size) {

            Object[] newValues = new Object[values.length + 5];
            for (int i = 0; i < size; i++) {
                newValues[i] = values[i];
            }
            values = newValues;
        }
    }
}