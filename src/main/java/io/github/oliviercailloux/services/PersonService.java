package io.github.oliviercailloux.services;


import io.github.oliviercailloux.Utils.QueryHelper;
import io.github.oliviercailloux.entities.Person;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

public class PersonService {
    @Inject
    private QueryHelper em;

    public Person persist(Person p) {
        return em.merge(p);
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);

    }

    public ArrayList<Person> findAll() {
        return em.findall("SELECT e FROM Person e");
    }


}
