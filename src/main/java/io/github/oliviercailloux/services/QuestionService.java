package io.github.oliviercailloux.services;

import io.github.oliviercailloux.Utils.QueryHelper;
import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;


public class QuestionService {

    @Inject
    private QueryHelper em;

    public Question persist(Question question) {
        return em.merge(question);
    }

    public Question findById(Long id) {
        return em.find(Question.class, id);

    }

    public ArrayList<Question> findAll() {
        return em.findall("SELECT e FROM Question e");
    }

}
