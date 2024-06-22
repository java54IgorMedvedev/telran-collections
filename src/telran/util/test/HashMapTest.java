package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.HashMap;

class HashMapTest extends AbstractMapTest {
    private HashMap<String, Integer> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMap<>();
    }
}
