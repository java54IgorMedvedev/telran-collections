package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import telran.util.LinkedList.Node;

public class LinkedHashSet<T> extends AbstractCollection<T> implements Set<T> {
	HashMap<T, Node<T>> map = new HashMap<>();
	LinkedList<T> list = new LinkedList<>();
	
	@Override
	public T get(T pattern) {
		Node<T> node = map.get(pattern);
		
		return node == null ? null : node.data;
	}

	@Override
	public boolean add(T obj) {
	    boolean added = !contains(obj);
	    if (added) {
	        map.put(obj, new LinkedList.Node<>(obj));
	        list.addNode(size++, map.get(obj));
	    }
	    return added;
	}

	@Override
	public boolean remove(T pattern) {
		Node<T> node = map.get(pattern);
		boolean res = false;
		if (node != null) {
			res = true;
			list.removeNode(node);
			map.remove(pattern);
			size--;
		}
		
		return res;
	}

	@Override
	public boolean contains(T pattern) {
	    Node<T> node = map.get(pattern);
	    return node != null;
	}

	@Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = list.head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}