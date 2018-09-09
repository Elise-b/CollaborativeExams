package io.github.oliviercailloux.services;


import io.github.oliviercailloux.Utils.QueryHelper;
import io.github.oliviercailloux.entities.Answer;

import javax.inject.Inject;
import java.util.ArrayList;

public class AnswerService {
    @Inject
    private QueryHelper em;

    public Answer persist(Answer answer) {
        return em.merge(answer);
    }

    public Answer findById(Long id) {
        return em.find(Answer.class, id);
    }

    public ArrayList<Answer> findAll() {
        return em.findall("SELECT e FROM Answer e");
    }

}
