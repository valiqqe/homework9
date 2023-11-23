package homework9.myHashMap;

public class Entry<K, V> {

    private K key;
    private V value;
    private Entry<K, V> nextEntry;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNextEntry() {
        return nextEntry;
    }

    public void setNextEntry(Entry<K, V> nextEntry) {
        this.nextEntry = nextEntry;
    }
}
