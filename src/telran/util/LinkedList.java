package telran.util;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    private class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public boolean add(T obj) {
    	//O[1]
        Node<T> node = new Node<>(obj);
        addNode(size, node);
        return true;
    }
    
    @Override
    public boolean remove(T pattern) {
    	//O[n]
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(pattern)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(T pattern) {
    	//O[n]
        return indexOf(pattern) != -1;
    }

    @Override
    public int size() {
    	//O[1]
        return size;
    }

    @Override
    public Iterator<T> iterator() {
    	//O[1]
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
            	//O[1]
                return current != null;
            }

            @Override
            public T next() {
            	//O[1]
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public T get(int index) {
    	//O[n]
        List.checkIndex(index, size, true);
        return getNode(index).data;
    }

    @Override
    public void add(int index, T obj) {
    	//O[n]
        List.checkIndex(index, size, false);
        Node<T> node = new Node<>(obj);
        addNode(index, node);
    }

    @Override
    public T remove(int index) {
    	//O[n]
        List.checkIndex(index, size, true);
        Node<T> node = getNode(index);
        removeNode(node);
        return node.data;
    }

    @Override
    public int indexOf(T pattern) {
    	//O[n]
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(pattern)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T pattern) {
        // O(n)
        int index = -1;
        Node<T> current = tail;
        while (current != null && index == -1) {
            if (current.data.equals(pattern)) {
                index = size - 1;
            }
            current = current.prev;
            size--;
        }
        return index;
    }

    private Node<T> getNode(int index) {
    	//O[n]
        return index < size / 2 ? getNodeFromHead(index) : getNodeFromTail(index);
    }

    private LinkedList<T>.Node<T> getNodeFromHead(int index) {
    	//O[n]
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private LinkedList<T>.Node<T> getNodeFromTail(int index) {
    	//O[n]
        Node<T> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.prev;
        }
        return current;
    }

    private void addNode(int index, Node<T> node) {
    	//O[n]
        if (index == 0) {
            addHead(node);
        } else if (index == size) {
            addTail(node);
        } else {
            addMiddle(node, index);
        }
        size++;
    }

    private void addMiddle(Node<T> node, int index) {
    	//O[n]
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrev = nodeNext.prev;
        nodeNext.prev = node;
        nodePrev.next = node;
        node.prev = nodePrev;
        node.next = nodeNext;
    }

    private void addTail(Node<T> node) {
    	//O[1]
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private void addHead(Node<T> node) {
    	//O[1]
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void removeNode(Node<T> node) {
    	//O[1]
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }
}
