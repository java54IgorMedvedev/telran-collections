package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.TreeSet;

public class TreeSetTest extends SortedSetTest {
    TreeSet<Integer> treeSet;

    @Override
    @BeforeEach
    void setUp() {
        collection = new TreeSet<>(); 
        super.setUp();
        treeSet = (TreeSet<Integer>) collection;
    }

    @Test
    void displayRootChildrenTest() {
        treeSet.displayRootChildren();
    }

    @Test
    void treeInversionTest() {
        treeSet.treeInversion();
        Integer[] expected = {100, 10, 1, -5, -20};
        Integer[] actual = new Integer[treeSet.size()];
        int index = 0;
        for (Integer num : treeSet) {
            actual[index++] = num;
        }
        assertArrayEquals(expected, actual);
        assertTrue(treeSet.contains(100));
    }

    @Test
    void displayTreeRotatedTest() {
        treeSet.setSpacesPerLevel(4);
        treeSet.displayTreeRotated();
    }

    @Test
    void widthTest() {
        assertEquals(2, treeSet.width());
    }

    @Test
    void heightTest() {
        assertEquals(4, treeSet.height());
    }

    @Test
    void sortedSequenceTreeTest() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] sortedArray = new Random().ints().distinct().limit(N_ELEMENTS).sorted().toArray();
        transformArray(sortedArray);
        for (int num : sortedArray) {
            treeSet.add(num);
        }
        balancedTreeTest(treeSet);
    }

    private void balancedTreeTest(TreeSet<Integer> treeSet) {
        assertEquals(20, treeSet.height());
        assertEquals((N_ELEMENTS + 1) / 2, treeSet.width());
    }

    @Test
    void balanceTreeTest() {
        createBigRandomCollection(new Random());
        treeSet.balance();
        balancedTreeTest(treeSet);
        int index = 0;
        for (Integer num : treeSet) {
            index++;
        }
        assertEquals(treeSet.size(), index);
    }

    private void transformArray(int[] sortedArray) {
        Arrays.sort(sortedArray);
        int[] balancedArray = new int[sortedArray.length];
        fillBalancedArray(sortedArray, balancedArray, 0, sortedArray.length - 1, 0);
        System.arraycopy(balancedArray, 0, sortedArray, 0, sortedArray.length);
    }

    private int fillBalancedArray(int[] sortedArray, int[] balancedArray, int start, int end, int index) {
        if (start > end) {
            return index;
        }

        int mid = (start + end) / 2;
        balancedArray[index++] = sortedArray[mid];

        index = fillBalancedArray(sortedArray, balancedArray, start, mid - 1, index);
        return fillBalancedArray(sortedArray, balancedArray, mid + 1, end, index);
    }
}
