package io.github.oliviercailloux.servlets;

import io.github.oliviercailloux.Utils.ServletHelper;
import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.services.PersonService;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    @Inject
    private PersonService personService;

    @Inject
    ServletHelper servletHelper;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            getPersonById(response, id);
        } else {

            getAllPerson(response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person personFromClient = servletHelper.getObjectFromRequest(request, Person.class);
        Person person = personService.persist(personFromClient);
        servletHelper.buildJsonResponse(response, person);
    }

    private void getPersonById( HttpServletResponse response, String id) {
        Person person = personService.findById((Long.parseLong(id)));
        servletHelper.buildJsonResponse(response, person);
    }

    private void getAllPerson(HttpServletResponse response) {
        ArrayList<Person> persons = personService.findAll();
        servletHelper.buildJsonResponse(response, persons);
    }


}
