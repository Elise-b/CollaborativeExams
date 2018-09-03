package io.github.oliviercailloux.Utils;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {

    public ServletHelper() {

    }

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

        }
        return "error";
    }


}
