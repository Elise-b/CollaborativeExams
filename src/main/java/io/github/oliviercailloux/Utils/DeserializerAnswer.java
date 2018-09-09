package io.github.oliviercailloux.Utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.oliviercailloux.entities.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DeserializerAnswer extends JsonDeserializer<List<Answer>> {
    @Override
    public List<Answer> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Answer> arr = mapper.readValue(node.toString(), ArrayList.class);
        return arr;
    }

}