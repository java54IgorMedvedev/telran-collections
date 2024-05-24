package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.LinkedList;

public class LinkedListTest {

    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.remove((Integer) 2));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertFalse(list.remove((Integer) 4));
    }

    @Test
    void testRemoveAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void testLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        assertEquals(3, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(4));
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }
}
