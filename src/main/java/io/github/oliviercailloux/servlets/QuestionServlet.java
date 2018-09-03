package io.github.oliviercailloux.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.github.oliviercailloux.Utils.ServletHelper;
import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions")
public class QuestionServlet extends HttpServlet {

    @Inject
    ServletHelper helper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person q = helper.getObjectFromRequest(request, Person.class);

        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json");
        response.getOutputStream().print(mapper.writeValueAsString(q));
        response.getOutputStream().flush();
        response.getOutputStream().flush();
    }

}




