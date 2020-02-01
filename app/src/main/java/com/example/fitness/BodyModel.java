package com.example.fitness;

public class BodyModel {
private int nb;
private String partName;
    public BodyModel(String name,int nb) {
        this.nb=nb;
        this.partName=name;
    }

    public int getNb() {
        return nb;
    }

    public String getPartName() {
        return partName;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }
}
