package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

class AbstractMapTest {
    private Map<Integer, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>(); 
    }

    @Test
    void testPut() {
        assertNull(map.put(1, 1));
        assertEquals(1, map.get(1));
        assertEquals(1, map.put(1, 2));
        assertEquals(2, map.get(1));
    }

    @Test
    void testRemove() {
        map.put(1, 1);
        assertEquals(1, map.remove(1));
        assertNull(map.get(1));
        assertNull(map.remove(1));
    }

    @Test
    void testKeySet() {
        map.put(1, 1);
        map.put(2, 2);
        Set<Integer> keys = map.keySet();
        assertEquals(2, keys.size());
        assertTrue(keys.contains(1));
        assertTrue(keys.contains(2));
    }

    @Test
    void testEntrySet() {
        map.put(1, 1);
        map.put(2, 2);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        assertEquals(2, entries.size());
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getKey().equals(1)) {
                assertEquals(1, entry.getValue());
            } else if (entry.getKey().equals(2)) {
                assertEquals(2, entry.getValue());
            } else {
                fail("Unexpected entry key: " + entry.getKey());
            }
        }
    }

    @Test
    void testValues() {
        map.put(1, 1);
        map.put(2, 2);
        Collection<Integer> values = map.values();
        assertEquals(2, values.size());
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }
}
