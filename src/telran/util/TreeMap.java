package telran.util;

import java.util.*;

public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {
    private TreeSet<Entry<K, V>> set;
    private Comparator<? super K> comparator;

    public TreeMap() {
        this(null);
    }

    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
        this.set = new TreeSet<>(new EntryComparator<>(comparator));
    }

    @Override
    public K firstKey() {
        Iterator<Entry<K, V>> iterator = set.iterator();
        K key = null;
        if (iterator.hasNext()) {
            key = iterator.next().getKey();
        }
        return key;
    }

    @Override
    public K lastKey() {
        Iterator<Entry<K, V>> iterator = set.iterator();
        K key = null;
        while (iterator.hasNext()) {
            key = iterator.next().getKey();
        }
        return key;
    }

    @Override
    public K floorKey(K key) {
        K result = null;
        boolean found = false;
        Iterator<Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext() && !found) {
            Entry<K, V> entry = iterator.next();
            if (compare(entry.getKey(), key) <= 0) {
                result = entry.getKey();
            } else {
                found = true;
            }
        }
        return result;
    }


    @Override
    public K ceilingKey(K key) {
        K result = null;
        boolean found = false;
        Iterator<Entry<K, V>> iterator = set.iterator();
        while (iterator.hasNext() && !found) {
            Entry<K, V> entry = iterator.next();
            if (compare(entry.getKey(), key) >= 0) {
                result = entry.getKey();
                found = true;
            }
        }
        return result;
    }

    @Override
    protected Set<K> getEmptyKeySet() {
        return new TreeSet<>();
    }

    private int compare(K k1, K k2) {
        return comparator == null ?
                ((Comparable<? super K>) k1).compareTo(k2) :
                comparator.compare(k1, k2);
    }

    private static class EntryComparator<K, V> implements Comparator<Entry<K, V>> {
        private final Comparator<? super K> comparator;

        public EntryComparator(Comparator<? super K> comparator) {
            this.comparator = comparator;
        }

        @Override
        public int compare(Entry<K, V> e1, Entry<K, V> e2) {
            return comparator == null ? ((Comparable<? super K>) e1.getKey()).compareTo(e2.getKey()) : comparator.compare(e1.getKey(), e2.getKey());
        }
    }
}
