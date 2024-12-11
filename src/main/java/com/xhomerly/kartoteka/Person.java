package com.xhomerly.kartoteka;

public class Person {
    private int id;
    private String fname;
    private String lname;
    private String description;

    public Person(int id, String fname, String lname, String description) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDescription() {
        return description;
    }
}
