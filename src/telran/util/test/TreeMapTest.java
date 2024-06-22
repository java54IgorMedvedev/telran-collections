package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.TreeMap;

class TreeMapTest extends AbstractMapTest {
    private TreeMap<String, Integer> treeMap;

    @BeforeEach
    public void setUp() {
        treeMap = new TreeMap<>();
    }

    @Test
    void testFirstKey() {
        assertNull(treeMap.firstKey());

        treeMap.put("key1", 1);
        assertEquals("key1", treeMap.firstKey());

        treeMap.put("key2", 2);
        assertEquals("key1", treeMap.firstKey());

        treeMap.put("key0", 0);
        assertEquals("key0", treeMap.firstKey());
    }

    @Test
    void testLastKey() {
        assertNull(treeMap.lastKey());

        treeMap.put("key1", 1);
        assertEquals("key1", treeMap.lastKey());

        treeMap.put("key2", 2);
        assertEquals("key2", treeMap.lastKey());

        treeMap.put("key0", 0);
        assertEquals("key2", treeMap.lastKey());
    }

    @Test
    void testFloorKey() {
        assertNull(treeMap.floorKey("key1"));

        treeMap.put("key1", 1);
        assertEquals("key1", treeMap.floorKey("key1"));
        assertEquals("key1", treeMap.floorKey("key2"));
        assertNull(treeMap.floorKey("key0"));

        treeMap.put("key2", 2);
        assertEquals("key2", treeMap.floorKey("key2"));
        assertEquals("key1", treeMap.floorKey("key3"));
    }

    @Test
    void testCeilingKey() {
        assertNull(treeMap.ceilingKey("key1"));

        treeMap.put("key1", 1);
        assertEquals("key1", treeMap.ceilingKey("key1"));
        assertEquals("key1", treeMap.ceilingKey("key0"));
        assertNull(treeMap.ceilingKey("key2"));

        treeMap.put("key2", 2);
        assertEquals("key2", treeMap.ceilingKey("key2"));
        assertEquals("key2", treeMap.ceilingKey("key1"));
    }
}
