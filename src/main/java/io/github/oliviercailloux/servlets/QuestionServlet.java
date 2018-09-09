package io.github.oliviercailloux.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.oliviercailloux.Utils.ServletHelper;
import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;
import io.github.oliviercailloux.services.PersonService;
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
    private QuestionService questionService;

    @Inject
    ServletHelper servletHelper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            getQuestionById(response, id);
        } else {
            getAllPerson(response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question questionFromClient = servletHelper.getObjectFromRequest(request, Question.class);
        Question question = questionService.persist(questionFromClient);
        servletHelper.buildJsonResponse(response, question);
    }

    private void getQuestionById(HttpServletResponse response, String id) {
        Question question = questionService.findById((Long.parseLong(id)));
        servletHelper.buildJsonResponse(response, question);
    }

    private void getAllPerson(HttpServletResponse response) {
        ArrayList<Question> questions = questionService.findAll();
        servletHelper.buildJsonResponse(response, questions);
    }


}




