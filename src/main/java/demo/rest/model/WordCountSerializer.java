package demo.rest.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class WordCountSerializer extends StdSerializer<WordCount> {

    public WordCountSerializer() {
        this(null);
    }
    public WordCountSerializer(Class<WordCount> t) {
        super(t);
    }

    @Override
    public void serialize(
            WordCount wc,
            JsonGenerator jgen,
            SerializerProvider provider
    ) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField(wc.word, wc.count);
        jgen.writeEndObject();
    }
}

