package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.HashMap;

class HashMapTest extends AbstractMapTest {

	@Override
	@BeforeEach
	void setUp() {
		map = new HashMap<>();
		super.setUp();
	}

	@Override
	protected <T> void sort(T[] expected, T[] actual) {
		Arrays.sort(expected);
		Arrays.sort(actual);
		
	}

	

}