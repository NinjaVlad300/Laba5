package com.example.lab5.books.classes;

public abstract class Book {

    final String name;
    String lang;


    protected Book(String name) {
        this.name = name;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public String getLang() {
        return lang;
    }
}
