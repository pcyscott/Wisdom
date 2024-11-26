package com.ll.domain.Wisdom.entity;

public class Wise {
    private String wise;
    private String author;
    private final int wisnum;

    public Wise(String wise, String author, int wisnum) {
        this.wise = wise;
        this.author = author;
        this.wisnum = wisnum;
    }

    public String toString() {
        return wisnum + " / " + author + " / " + wise;
    }

    public int getWisnum() {
        return wisnum;
    }

    public String getWise() {
        return wise;
    }

    public String getAuthor() {
        return author;
    }

    public void setWise(String wise) {
        this.wise = wise;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
