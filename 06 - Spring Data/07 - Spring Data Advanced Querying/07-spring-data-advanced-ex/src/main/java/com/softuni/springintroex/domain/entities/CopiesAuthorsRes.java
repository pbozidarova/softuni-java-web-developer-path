package com.softuni.springintroex.domain.entities;

public class CopiesAuthorsRes {

    String first_name;
    String last_name;
    int copies;

    public CopiesAuthorsRes() {
    }

    public int getCopies() {
        return copies;
    }

    public CopiesAuthorsRes setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public CopiesAuthorsRes setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public CopiesAuthorsRes setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }
}
