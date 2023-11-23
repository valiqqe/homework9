package homework9.myHashMap;

public class MyHashMap<K, V> {

    private Entry<K, V>[] buckets;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }

    public void clear() {
        this.buckets = new Entry[10];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = kvEntry;
        } else {
            kvEntry.setNextEntry(buckets[bucketNumber]);
            buckets[bucketNumber] = kvEntry;
        }
    }
    public void remove(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        Entry<K, V> previousEntry = null;

        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                if (previousEntry == null) {
                    buckets[bucketNumber] = currentEntry.getNextEntry();
                } else {
                    previousEntry.setNextEntry(currentEntry.getNextEntry());
                }
                return;
            }

            previousEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }
    public int size() {
        int size = 0;

        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> currentEntry = bucket;

            while (currentEntry != null) {
                size++;
                currentEntry = currentEntry.getNextEntry();
            }
        }

        return size;
    }
    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            V v = checkEquals(currentEntry, key);
            if (v != null)
                return v;

            currentEntry = currentEntry.getNextEntry();
        }
        return checkEquals(currentEntry, key);

    }

    private V checkEquals(Entry<K, V> e, K key) {
        if (e.getKey().equals(key)) {
            return e.getValue();
        }
        return null;
    }
}
