package containpackage.model.generators.containers;

import containpackage.model.entities.containers.Record;
import containpackage.model.entities.containers.Registry;
import containpackage.model.entities.books.Book;
import containpackage.model.entities.humans.Human;
import containpackage.model.entities.humans.Professor;
import containpackage.model.entities.humans.Student;
import containpackage.model.generators.humans.HumanGenerator;
import containpackage.model.generators.humans.ProfessorGenerator;
import containpackage.model.generators.humans.StudentGenerator;
import containpackage.model.generators.sub.RandomIntegerGenerator;

import java.util.*;

public class RegistryGenerator implements RandomIntegerGenerator{

    private Registry registry;

    public RegistryGenerator(){
        this.registry = new Registry();
    }

    private List<Human> studentList;
    private List<Human> professorList;

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
        studentList = new ArrayList<>(students);
        HashSet<Human> professors = generatorProfessor.convert();
        professorList =new ArrayList<>(professors);
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

    public List<Human> getStudentList() {
        return studentList;
    }

    public List<Human> getProfessorList() {
        return professorList;
    }
}