package demo.rest.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountSerializerTest {

    @Test
    public void testJsonSerializer() throws IOException {

        WordCount[] wordCounts = {
                new WordCount("abc",2),
                new WordCount("def", 3)
        };

        String actual = new ObjectMapper().writeValueAsString(new Count(wordCounts));
        assertEquals("{\"counts\":[{\"abc\":2},{\"def\":3}]}", actual);
    }

}
