

import java.time.temporal.ValueRange;
import java.util.Iterator;
import java.util.function.Consumer;


public class Hashtable<K, V> {
    private Entry<K,V>[] values;
    private int size;

    public Hashtable(int initialCapacity) {
        values = (Entry<K,V>[])new Entry[initialCapacity];
    }

    /**
     * #3b. Implement this (1 point)
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int hashCode = key.hashCode() % values.length;
        Entry<K,V> list = values[hashCode];
        if(list != null){
            Entry<K,V> current = list;
           while(current != null){
               if(current.key == key){
                   current.data = value;
                   break;
               }
               if(current.next != null) {
                   current = current.next;
               }else{
                   break;
               }
           }
            current.next = new Entry<K,V>(key, value);
        }else{
            values[hashCode] = new Entry<K,V>(key,value);
        }
    }

    /**
     * #3b. Implement this (1 point)
     * @param key
     * @return
     */
    public V get(K key) {
        int hashcode = key.hashCode() % values.length;
        Entry<K,V> list = values[hashcode];
        if(list != null) {
            Entry<K, V> curr = list;
            while (curr != null) {
                if (curr.key == key) {
                    return curr.data;
                }
                curr = curr.next;
            }
            return list.data;
        }
        return null;
    }

    /**
     * #3c.  Implement this. (1 point)
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        int hashCode = key.hashCode() % values.length;
        Entry<K, V> list = values[hashCode];
        if(list != null) {
            Entry<K, V> curr = list.next;
            if (list.key == key) {
                values[hashCode] = curr;
                return list.data;
            }
            while (curr != null) {
                if (curr.key == key) {
                    list.next = curr.next;
                    return curr.data;
                }
                list = curr;
                curr = curr.next;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return this.get(key) != null;
    }

    public Iterator<V> values() {
        return new Iterator<V>() {
            private int count = 0;
            private Entry<K, V> currentEntry;

            {
                while ( ( currentEntry = values[count] ) == null && count < values.length ) {
                    count++;
                }
            }

            @Override
            public void forEachRemaining(Consumer<? super V> arg0) {
            }

            @Override
            public boolean hasNext() {
                return count < values.length;
            }

            @Override
            public V next() {
                V toReturn = currentEntry.data;
                currentEntry = currentEntry.next;
                while ( currentEntry == null && ++count < values.length && (currentEntry = values[count]) == null );
                return toReturn;
            }

            @Override
            public void remove() {
            }

        };
    }

    private static class Entry<K, V> {
        private K key;
        private V data;
        private Entry<K,V> next;

        public Entry(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return "{" + key + "=" + data + "}";
        }
    }
}