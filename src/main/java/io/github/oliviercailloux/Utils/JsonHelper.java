package io.github.oliviercailloux.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.oliviercailloux.entities.Question;

public class JsonHelper {

    public static <T> T convertJsontoObject(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {

        }
        return null;
    }
}
