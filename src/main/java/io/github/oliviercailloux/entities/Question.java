package io.github.oliviercailloux.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.oliviercailloux.Utils.DeserializerAnswer;
import io.github.oliviercailloux.Utils.DeserializerPerson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
public class Question {

  //  @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String phrasing;
    private String language;
    @JsonDeserialize(using= DeserializerPerson.class)
    //@OneToOne
    private Person person;
    //@JsonDeserialize(using= DeserializerAnswer.class)
    //@OneToMany
    //private ArrayList<Answer> answers;
}
