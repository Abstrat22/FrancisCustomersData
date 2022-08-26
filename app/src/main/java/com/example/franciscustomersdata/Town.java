package com.example.franciscustomersdata;

//Person's Data
public class Town {

    private String townName;

    public Town(String townName) {
        this.townName = townName;
    }


    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Override
    public String toString() {
        return "Town{" +
                "townName='" + townName + '\'' +
                '}';
    }
}
