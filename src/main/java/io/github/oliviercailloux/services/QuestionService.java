package io.github.oliviercailloux.services;

import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class QuestionService {

    @PersistenceContext(unitName = "collaborativeExamsPU")
    private EntityManager em;

    public void persistData(Question question){
        em.persist(question);
    }
}
