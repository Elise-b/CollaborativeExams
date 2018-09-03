package io.github.oliviercailloux.entities;

import java.util.ArrayList;

public class Question {

    private String phrasing;
    private String language;
    private int id;
    private Person author;
    private ArrayList<Answer> answers;

    public Question() {
    }


    public void setPhrasing(String phrasing) {
        this.phrasing = phrasing;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getPhrasing() {
        return phrasing;
    }

    public String getLanguage() {
        return language;
    }

    public int getId() {
        return id;
    }

    public Person getAuthor() {
        return author;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }


}
