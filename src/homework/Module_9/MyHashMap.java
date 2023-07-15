package homework.Module_9;


//Написать свой класс MyHashMap как аналог классу HashMap.
//
//        Нужно делать с помощью односвязной Node.
//
//        Не может хранить две ноды с одинаковых ключами одновременно.
//
//        Методы
//
//        put(Object key, Object value) добавляет пару ключ + значение
//        remove(Object key) удаляет пару по ключу
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(Object key) возвращает значение(Object value) по ключу

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Entry<K, V>[] buckets;
    private int size;

    public MyHashMap(){
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
    private int getIndex(K key) {
        return key.hashCode() % buckets.length;
    }

    private void resize(){
        int newCapacity = buckets.length * 2;
        Entry<K, V>[] newBuckets = new Entry[newCapacity];
        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                int index = getIndex(entry.getKey());
                Entry<K, V> next = entry.getNext();

                if (newBuckets[index] == null) {
                    newBuckets[index] = entry;
                    entry.setNext(null);
                } else {
                    Entry<K, V> existingEntry = newBuckets[index];
                    while (existingEntry.getNext() != null) {
                        existingEntry = existingEntry.getNext();
                    }
                    existingEntry.setNext(entry);
                    entry.setNext(null);
                }

                entry = next;
            }
        }

        buckets = newBuckets;

    }
    public void put(K key, V value) {
        if(size >= LOAD_FACTOR * buckets.length){
            resize();
        }
        int index = getIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> entry = buckets[index];
            while (true) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
                if (entry.getNext() == null) {
                    entry.setNext(new Entry<>(key, value));
                    size++;
                    return;
                }
                entry = entry.getNext();
            }
        }
    }
    public void remove(K key) {
        int index = getIndex(key);

        Entry<K, V> entry = buckets[index];
        Entry<K, V> prev = null;

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                if (prev == null) {
                    buckets[index] = entry.getNext();
                } else {
                    prev.setNext(entry.getNext());
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.getNext();
        }
    }
    public void clear(){
        buckets = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);

        Entry<K, V> entry = buckets[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;
        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.getKey()).append("=").append(entry.getValue());
                first = false;
                entry = entry.getNext();
            }
        }

        sb.append("}");
        return sb.toString();
    }
}

