package io.github.oliviercailloux.entities;

public class Person {

    private int id;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Person() {
    }
}
