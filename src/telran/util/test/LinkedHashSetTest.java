package telran.util.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

import telran.util.HashSet;
import telran.util.LinkedHashSet;

public class LinkedHashSetTest extends SetTest {
@Override
@BeforeEach
void setUp() {
	collection = new LinkedHashSet<>(); 
	super.setUp();
}

}