package telran.util.test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.Collection;

public abstract class CollectionTest {
	protected Collection<Integer> collection;
	Integer[] numbers = { -20, 10, 1, 100, -5 };

	@BeforeEach
	void setUp() {
		for (Integer num : numbers) {
			collection.add(num);
		}
	}

	@Test
	void iteratorTest() {
		runTest(numbers);
	}

	protected void runTest(Integer[] expected) {
		Integer[] actual = collection.stream().toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	}

	@Test
	void testAdd() {
		assertTrue(collection.add(200));
		assertTrue(collection.contains(200));
		assertEquals(numbers.length + 1, collection.size());
	}

	@Test
	void testRemove() {
		assertTrue(collection.remove((Integer) 10));
		assertFalse(collection.contains(10));
		assertEquals(numbers.length - 1, collection.size());
		assertFalse(collection.remove((Integer) 1000));
	}

	@Test
	void testContains() {
		assertTrue(collection.contains(10));
		assertFalse(collection.contains(1000));
	}

	@Test
	void testSize() {
		assertEquals(numbers.length, collection.size());
	}
}