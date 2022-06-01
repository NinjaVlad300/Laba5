package model.generators.humans;

import model.entities.books.Book;
import model.entities.books.EnglishLiterature;
import model.entities.humans.Human;
import model.entities.humans.Student;
import model.parsers.humans.StudentParser;

import java.util.ArrayList;
import java.util.HashSet;

public class StudentGenerator implements HumanGenerator{

    private HashSet<Object> students;

    public HashSet<Object> get() {
        return students;
    }

    public StudentGenerator(){
        this.students = new HashSet<>();
    }

    @Override
    public String[] generateArguments(){
        ArrayList<String> firstNames = getFirstNames();
        ArrayList<String> lastNames = getLastNames();
        // all indexes are random comparing to each other
        String firstName = firstNames.get(getRandomIndex(firstNames));
        String lastName = getCorrectLastName(firstName, lastNames.get(getRandomIndex(lastNames)));
        return new String[]{firstName, lastName};
    }

    @Override
    public Human generate(String[] args){
        return new Student(args[0], args[1]);
    }

    @Override
    public ArrayList<String> getFirstNames(){
        return StudentParser.getFirstNames();
    }

    @Override
    public ArrayList<String> getLastNames(){
        return StudentParser.getLastNames();
    }

}
