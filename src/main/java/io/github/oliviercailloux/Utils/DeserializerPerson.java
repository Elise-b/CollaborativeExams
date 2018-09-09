package io.github.oliviercailloux.Utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.oliviercailloux.entities.Person;

import java.io.IOException;


public class DeserializerPerson extends JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        Long id = node.get("id").asLong();
        String email = node.get("email").asText();

        Person person = new Person();
        person.setId(id);
        person.setEmail(email);

        return person;
    }

}