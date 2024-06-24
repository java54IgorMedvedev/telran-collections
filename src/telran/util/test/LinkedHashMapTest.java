package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.LinkedHashMap;

class LinkedHashMapTest extends AbstractMapTest {
	@Override
	@BeforeEach
	void setUp() {
		map = new LinkedHashMap<>();
		super.setUp();
	}
	@Override
	protected <T> void sort(T[] expected, T[] actual) {
		// keeps order neither expected nor actual should be sorted
		
	}

	

}