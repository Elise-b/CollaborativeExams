package io.github.oliviercailloux.services;

import io.github.oliviercailloux.entities.Person;
import io.github.oliviercailloux.entities.Question;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;


public class QuestionService {

    private EntityManager em;

    public Question persistData(Question question) {

        Person p = question.getPerson();
        em.persist(p);
        return em.merge(question);
    }

    public void persistP(Person p) {
        em.persist(p);
    }

    public Collection<Person> findAllPerson() {
        Query query = em.createQuery("SELECT e FROM Person e");
        return (Collection<Person>) query.getResultList();
    }
}
