package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }

    @Override
    public boolean add(T obj) {
        if (size == array.length) {
            allocate();
        }
        array[size++] = obj;
        return true;
    }

    private void allocate() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public boolean remove(T pattern) {
        int index = indexOf(pattern);
        if (index > -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T pattern) {
        return indexOf(pattern) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void add(int index, T obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            allocate();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = obj;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;  
        return removedElement;
    }

    @Override
    public int indexOf(T pattern) {
        int index = -1;
        for (int i = 0; i < size && index == -1; i++) {
            if ((pattern == null && array[i] == null) || (pattern != null && pattern.equals(array[i]))) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(T pattern) {
        int index = -1;
        for (int i = size - 1; i >= 0 && index == -1; i--) {
            if ((pattern == null && array[i] == null) || (pattern != null && pattern.equals(array[i]))) {
                index = i;
            }
        }
        return index;
    }
}
