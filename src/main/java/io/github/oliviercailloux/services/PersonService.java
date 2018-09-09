package io.github.oliviercailloux.services;


import io.github.oliviercailloux.entities.Person;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless
@LocalBean
public class PersonService {
    @PersistenceContext(unitName = "collaborativeExamsPU")
    private EntityManager em;

    public Person persist(Person p) {
        Person person = em.merge(p);
        em.close();
        return person;
    }

    public Person findById(Long id) {
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public ArrayList<Person> findAll() {
        Query query = em.createQuery("SELECT e FROM Person e");
        ArrayList<Person> persons =  (ArrayList<Person>) query.getResultList();
        em.close();
        return persons;
    }
}
