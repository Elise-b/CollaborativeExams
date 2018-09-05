package io.github.oliviercailloux.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
//@Entity
public class Question {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String phrasing;
    private String language;
    private Person author;
    private ArrayList<Answer> answers;
}
