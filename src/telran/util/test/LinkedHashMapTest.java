package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.LinkedHashMap;

class LinkedHashMapTest extends AbstractMapTest {
    private LinkedHashMap<String, Integer> linkedHashMap;

    @BeforeEach
    public void setUp() {
        linkedHashMap = new LinkedHashMap<>();
    }
}
