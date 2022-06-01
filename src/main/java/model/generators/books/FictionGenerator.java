package model.generators.books;

import model.entities.books.Book;
import model.entities.books.Fiction;
import model.parsers.books.FictionParser;

import java.util.ArrayList;
import java.util.HashSet;

public class FictionGenerator implements BookGenerator{

    private HashSet<Object> fictions;

    public HashSet<Object> get() {
        return fictions;
    }

    public FictionGenerator() {
        this.fictions = new HashSet<>();
    }

    @Override
    public String[] generateArguments(){
        ArrayList<String> authors = getAuthors();
        ArrayList<String> titles = getTitles();
        // using the same index for "author" and "title" -> to implement the functionality of "different generation"
        int fictionIndex = getRandomIndex(authors);
        return new String[]{authors.get(fictionIndex), titles.get(fictionIndex)};
    }

    @Override
    public Book generate(String[] args){
        return new Fiction(args[0], args[1]);
    }

    public ArrayList<String> getAuthors(){
        return FictionParser.getAuthors();
    }

    public ArrayList<String> getTitles(){
        return FictionParser.getTitles();
    }

}
