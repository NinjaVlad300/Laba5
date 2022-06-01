package model.generators.books;

import model.entities.books.Book;
import model.entities.books.EnglishLiterature;
import model.parsers.books.EnglishLiteratureParser;

import java.util.ArrayList;
import java.util.HashSet;

public class EnglishLiteratureGenerator implements BookGenerator{

    private HashSet<Object> englishLiteratures;

    public HashSet<Object> get() {
        return englishLiteratures;
    }

    public EnglishLiteratureGenerator(){
        this.englishLiteratures = new HashSet<>();
    }

    @Override
    public String[] generateArguments(){
        ArrayList<String> authors = getAuthors();
        ArrayList<String> titles = getTitles();
        ArrayList<String> disciplines = getDisciplines();
        ArrayList<String> levels = getLevels();
        ArrayList<String> universities = getUniversities();
        // all indexes are random comparing to each other
        String author = authors.get(getRandomIndex(authors));
        String title = titles.get(getRandomIndex(titles));
        String discipline = disciplines.get(getRandomIndex(disciplines));
        String level = levels.get(getRandomIndex(levels));
        String university = universities.get(getRandomIndex(universities));
        return new String[]{author, title, discipline, level, university};
    }

    @Override
    public Book generate(String[] args){
        return new EnglishLiterature(args[0], args[1], args[2], args[3], args[4]);
    }

    public ArrayList<String> getAuthors(){
        return EnglishLiteratureParser.getAuthors();
    }

    public ArrayList<String> getTitles(){
        return EnglishLiteratureParser.getTitles();
    }

    public ArrayList<String> getDisciplines(){
        return EnglishLiteratureParser.getDisciplines();
    }

    public ArrayList<String> getLevels(){
        return EnglishLiteratureParser.getLevels();
    }

    public ArrayList<String> getUniversities(){
        return EnglishLiteratureParser.getUniversities();
    }

}
