package telran.util.test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.List;

public abstract class ListTest extends CollectionTest {
	List<Integer> list;

	@BeforeEach
	@Override
	void setUp() {
		super.setUp();
		list = (List<Integer>) collection;
	}

	@Test
	void testGet() {
		assertEquals((Integer)(-20), list.get(0));
		assertEquals((Integer)10, list.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(100));
	}

	@Test
	void testAddAtIndex() {
		list.add(2, 50);
		assertEquals((Integer)50, list.get(2));
		assertEquals(numbers.length + 1, list.size());
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(100, 10));
	}

	@Test
	void testRemoveAtIndex() {
		Integer removed = list.remove(2);
		assertEquals((Integer)1, removed);
		assertEquals(numbers.length - 1, list.size());
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));
	}

	@Test
	void testIndexOf() {
		assertEquals(1, list.indexOf(10));
		assertEquals(-1, list.indexOf(1000));
	}

	@Test
	void testLastIndexOf() {
		list.add(2, 10);
		assertEquals(2, list.lastIndexOf(10));
		assertEquals(-1, list.lastIndexOf(1000));
	}
}