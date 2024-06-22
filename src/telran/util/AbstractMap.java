package telran.util;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractMap<K, V> implements Map<K, V> {
     protected Set<Entry<K, V>> set;
     abstract protected Set<K> getEmptyKeySet();
     
     protected Entry<K, V> getEntry(K key) {
    	    Entry<K, V> result = null;
    	    for (Entry<K, V> entry : set) {
    	        if (Objects.equals(entry.getKey(), key)) {
    	            result = entry;
    	        }
    	    }
    	    return result;
    	}

     
	@Override
	public V get(K key) {
		Entry<K, V> pattern = new Entry<>(key, null);
		Entry<K, V> entry = set.get(pattern);
		V res = null;
		if (entry != null) {
			res = entry.getValue();
		}
		return res;
	}

	@Override
	public V put(K key, V value) {
	    Entry<K, V> newEntry = new Entry<>(key, value);
	    Entry<K, V> existingEntry = getEntry(key);
	    
	    V oldValue = null;
	    
	    if (existingEntry != null) {
	        oldValue = existingEntry.getValue();
	        existingEntry.setValue(value);
	    } else {
	        set.add(newEntry);
	    }
	    
	    return oldValue;
	}

	@Override
	public V remove(K key) {
	    if (key == null) {
	        throw new NullPointerException("Null key is not supported in Map");
	    }

	    Entry<K, V> entryToRemove = null;
	    V removedValue = null;
	    boolean found = false;

	    Iterator<Entry<K, V>> iterator = set.iterator();
	    while (iterator.hasNext()) {
	        Entry<K, V> entry = iterator.next();
	        if (entry.getKey().equals(key)) {
	            entryToRemove = entry;
	            removedValue = entry.getValue();
	            iterator.remove(); 
	            found = true;
	        }
	    }

	    if (!found) {
	        removedValue = null; 
	    }

	    return removedValue;
	}


	@Override
	public Set<K> keySet() {
		Set<K> setKey = getEmptyKeySet();
		set.forEach(e -> setKey.add(e.getKey()));
		return setKey;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		
		return set;
	}

	@Override
	public Collection<V> values() {
		ArrayList<V> res = new ArrayList<>();
		set.forEach(e -> res.add(e.getValue()));
		return res;
	}

}