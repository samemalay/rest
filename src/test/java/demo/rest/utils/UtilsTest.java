package demo.rest.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UtilsTest {

    @Test
    public void testReadData()
    {
        assertEquals(6129, Utils.readData().length());
    }

    @Test
    public void testMultiCount()
    {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 3);
        expected.put("test", 2);
        expected.put("function", 1);
        Set<String> words = new HashSet<>(Arrays.asList("a", "test", "function"));
        assertEquals(expected, Utils.multiCount("this is a test, and is a test of a function.", words));
    }

    @Test
    public void testTopCount()
    {
        List<Map.Entry<String, Integer>> expected = new ArrayList<>();
        expected.add(new AbstractMap.SimpleEntry<String, Integer>("a", 3));
        expected.add(new AbstractMap.SimpleEntry<String, Integer>("test", 2));
        expected.add(new AbstractMap.SimpleEntry<String, Integer>("is", 2));
        assertEquals(expected, Utils.topCount("this is a test, and is a test of a function.", 3));
    }

}
