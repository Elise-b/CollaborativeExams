package io.github.oliviercailloux.servlets;

import io.github.oliviercailloux.Utils.ServletHelper;
import io.github.oliviercailloux.entities.Answer;
import io.github.oliviercailloux.services.AnswerService;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {

    @Inject
    private AnswerService answerService;
    @Inject
    ServletHelper servletHelper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            getAanswerById(response, id);
        } else {
            getAllAnswer(response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Answer answerFromClient = servletHelper.getObjectFromRequest(request, Answer.class);
        Answer answer = answerService.persist(answerFromClient);
        servletHelper.buildJsonResponse(response, answer);
    }

    private void getAanswerById(HttpServletResponse response, String id) {
        Answer answer = answerService.findById((Long.parseLong(id)));
        servletHelper.buildJsonResponse(response, answer);
    }

    private void getAllAnswer(HttpServletResponse response) {
        ArrayList<Answer> answers = answerService.findAll();
        servletHelper.buildJsonResponse(response, answers);
    }


}
