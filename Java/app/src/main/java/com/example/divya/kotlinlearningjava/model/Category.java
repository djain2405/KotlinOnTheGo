package com.example.divya.kotlinlearningjava.model;

public class Category {

    //default contructor
    public Category()
    {

    }

    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
}
