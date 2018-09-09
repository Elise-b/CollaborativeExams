package io.github.oliviercailloux.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.oliviercailloux.Utils.ServletHelper;
import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;
import io.github.oliviercailloux.services.QuestionService;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

    @Inject
    ServletHelper servletHelper;

    @Inject
    QuestionService questionService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        p.setEmail("maxime.com1");
        questionService.persistP(p);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question k = new Question();
        Person p = new Person();
        p.setId(1l);
        p.setEmail("elise bro");
        k.setLanguage("francais");
        k.setPerson(p);

       //Question question = servletHelper.getObjectFromRequest(request, Question.class);

        Question  pp = questionService.persistData(k);
        //ArrayList<Person> p = (ArrayList<Person> )questionService.findAllPerson();
        //Person pp  = p.get(1);
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json");
        response.getOutputStream().print(mapper.writeValueAsString(pp));
        response.getOutputStream().flush();
        response.getOutputStream().flush();
    }

}




