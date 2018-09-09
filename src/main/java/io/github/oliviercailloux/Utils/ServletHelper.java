package io.github.oliviercailloux.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.oliviercailloux.entities.Person;
import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ServletHelper {

    public <T> T getObjectFromRequest(HttpServletRequest request, Class<T> clazz) {
        String jsonString = readJsonFromRequest(request);
        T instance = JsonHelper.convertJsontoObject(jsonString, clazz);
        return instance;
    }

    public String readJsonFromRequest(HttpServletRequest request) {
        try {
            StringBuilder sb = new StringBuilder();
            String jsonString;
            while ((jsonString = request.getReader().readLine()) != null) {
                sb.append(jsonString);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> void buildJsonResponse(HttpServletResponse response, T entitie) {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        try {
            response.getOutputStream().print(mapper.writeValueAsString(entitie));
            response.getOutputStream().flush();
            response.getOutputStream().flush();
        } catch (Exception e) {
            throw new RuntimeException("couldn't build response ");
        }
    }

}
