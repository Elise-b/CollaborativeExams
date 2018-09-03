package io.github.oliviercailloux.entities;


public class Answer {

    private String phrasing;

    private String isCorrect;

    public Answer(String phrasing, String isCorrect) {
        this.phrasing = phrasing;
        this.isCorrect = isCorrect;
    }

    public void setPhrasing(String phrasing) {
        this.phrasing = phrasing;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getPhrasing() {
        return phrasing;
    }

    public String getIsCorrect() {
        return isCorrect;
    }
}




