package containpackage.model.generators.humans;

import containpackage.model.entities.books.Book;
import containpackage.model.entities.books.BooksNumber;
import containpackage.model.entities.containers.Record;
import containpackage.model.entities.humans.Human;
import containpackage.model.entities.humans.Professor;
import containpackage.model.generators.containers.RegistryGenerator;
import containpackage.model.parsers.humans.ProfessorParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ProfessorGenerator implements HumanGenerator{

    private HashSet<Object> professors;

    public HashSet<Object> get() {
        return professors;
    }

    public ProfessorGenerator(){
        this.professors = new HashSet<>();
    }

    @Override
    public String[] generateArguments(){
        ArrayList<String> firstNames = getFirstNames();
        ArrayList<String> lastNames = getLastNames();
        // all indexes are random comparing to each other
        String firstName = firstNames.get(getRandomIndex(firstNames));
        String lastName = getCorrectLastName(firstName, lastNames.get(getRandomIndex(lastNames)));
        String secondName = getSecondName(firstName);
        return new String[]{firstName, secondName, lastName};
    }

    @Override
    public Human generate(String[] args){
        return new Professor(args[0], args[1], args[2]);
    }

    @Override
    public LinkedHashSet<Record> generateRecords(Human human){
        LinkedHashSet<Record> records = new LinkedHashSet<>();
        for(int month=1; month<=3; month++){
            HashSet<Book> books = generateBooksForHuman(human, new BooksNumber(1, month%2, (month+1)%2));
            records.addAll(RegistryGenerator.createRecords(human, books, month));
        }
        return records;
    }

    @Override
    public ArrayList<String> getFirstNames(){
        return ProfessorParser.getFirstNames();
    }

    @Override
    public ArrayList<String> getLastNames(){
        return ProfessorParser.getLastNames();
    }

}