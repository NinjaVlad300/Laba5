package model.entities.humans;

import model.entities.books.Book;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Human{

    private final String firstName;
    private final String lastName;
    private final HashSet<Book> books;

    public Human(String firstName, String lastName){
        this(firstName, lastName, new HashSet<>());
    }

    public Human(String firstName, String lastName, HashSet<Book> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    //

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    //

    public void addBook(Book book){
        getBooks().add(book);
    }

    public void addBooks(HashSet<Book> books){
        for(Book book : books){
            addBook(book);
        }
    }

    public static boolean isMale(String firstName){
        return !(firstName.endsWith("а") || firstName.endsWith("я"));
    }

}
