package com.example.fitness;

public class ExerciceModel {
private String nb;
private String rep;
private String title;
    public ExerciceModel(String title,String rep, String nb) {
        this.nb=nb;
        this.title=title;
        this.rep=rep;
    }

    public ExerciceModel(String title,String rep) {
        this.title=title;
        this.rep=rep;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getNb() {
        return nb;
    }

    public String getrep() {
        return rep;
    }

    public void setNb(String nb) {
        this.nb = nb;
    }

    public void setrep(String rep) {
        this.rep = rep;
    }
}
