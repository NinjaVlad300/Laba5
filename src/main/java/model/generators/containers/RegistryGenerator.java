package model.generators.containers;

import model.entities.containers.Record;
import model.entities.containers.Registry;
import model.entities.books.Book;
import model.entities.humans.Human;
import model.generators.humans.HumanGenerator;
import model.generators.humans.ProfessorGenerator;
import model.generators.humans.StudentGenerator;
import model.generators.sub.RandomIntegerGenerator;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class RegistryGenerator implements RandomIntegerGenerator{

    private Registry registry;

    public RegistryGenerator(){
        this.registry = new Registry();
    }

    public Registry getRegistry() {
        return registry;
    }

    //

    public void generate(int humansNumber){
        int studentsNumber = getRandomIntegerIncludingEdge(humansNumber);
        int professorsNumber = humansNumber - studentsNumber;
        //
        HumanGenerator generatorStudent = new StudentGenerator();
        HumanGenerator generatorProfessor = new ProfessorGenerator();
        //
        generatorStudent.generate(studentsNumber);
        generatorProfessor.generate(professorsNumber);
        //
        HashSet<Human> students = generatorStudent.convert();
        HashSet<Human> professors = generatorProfessor.convert();
        //
        for(Human student : students){
            addRecords(generatorStudent.generateRecords(student));
        }
        for(Human professor : professors){
            addRecords(generatorProfessor.generateRecords(professor));
        }
    }

    public static Collection<? extends Record> createRecords(Human human, HashSet<Book> books, int month){
        LinkedHashSet<Record> records = new LinkedHashSet<>();
        for(Book book : books){
            records.add(new Record(human, book, month));
        }
        return records;
    }

    public void addRecords(LinkedHashSet<Record> records){
        getRegistry().addRecords(records);
    }

}