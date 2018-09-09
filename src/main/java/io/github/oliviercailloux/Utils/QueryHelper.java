package io.github.oliviercailloux.Utils;

import io.github.oliviercailloux.entities.Person;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless
@LocalBean
public class QueryHelper {
    @PersistenceContext(unitName = "collaborativeExamsPU2")
    private EntityManager em;

    public <T> T merge(T entitie) {
        return em.merge(entitie);
    }

    public <T> T find(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }

    public <T> ArrayList<T> findall(String queryString) {
        Query query = em.createQuery(queryString);
        ArrayList<T> entities = (ArrayList<T>) query.getResultList();
        return entities;
    }

    @PreDestroy
    public void closeEMF() {
        em.getEntityManagerFactory().close();
    }

}
