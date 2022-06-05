package model.generators.humans;

import model.entities.books.Book;
import model.entities.books.BooksNumber;
import model.entities.books.EnglishLiterature;
import model.entities.containers.Record;
import model.entities.humans.Human;
import model.entities.humans.Student;
import model.generators.containers.RegistryGenerator;
import model.parsers.humans.StudentParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

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
    public LinkedHashSet<Record> generateRecords(Human human){
        LinkedHashSet<Record> records = new LinkedHashSet<>();
        HashSet<Book> books = generateBooksForHuman(human, new BooksNumber(0, 2, 2));
        records.addAll(RegistryGenerator.createRecords(human, books, 1));
        for(int month=2; month<=3; month++){
            books = generateBooksForHuman(human, new BooksNumber(0, month%2, (month+1)%2));
            records.addAll(RegistryGenerator.createRecords(human, books, month));
        }
        return records;
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
