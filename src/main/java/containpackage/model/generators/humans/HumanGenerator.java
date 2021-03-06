package containpackage.model.generators.humans;

import containpackage.model.entities.books.Book;
import containpackage.model.entities.books.BooksNumber;
import containpackage.model.entities.containers.Record;
import containpackage.model.entities.humans.Human;
import containpackage.model.generators.Generator;
import containpackage.model.generators.books.EnglishLiteratureGenerator;
import containpackage.model.generators.books.FictionGenerator;
import containpackage.model.generators.books.RussianLiteratureGenerator;
import containpackage.model.generators.sub.RandomIntegerGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public interface HumanGenerator extends RandomIntegerGenerator, Generator{

    default void generate(int humansNumber){
        generateWithBooks(humansNumber, new BooksNumber(0,0,0));
    }

    default void generateWithBooks(int humansNumber, int booksNumber){
        for(int i=1; i<=humansNumber; i++){
            int fictionsNumber = getRandomIntegerIncludingEdge(booksNumber);
            int russianLiteraturesNumber = getRandomIntegerIncludingEdge(booksNumber-fictionsNumber);
            int englishLiteraturesNumber = booksNumber-(fictionsNumber+russianLiteraturesNumber);
            generateWithBooks(new BooksNumber(fictionsNumber, russianLiteraturesNumber, englishLiteraturesNumber));
        }
    }

    default void generateWithBooks(int humansNumber, BooksNumber booksNumber){
        for(int i=1; i<=humansNumber; i++){
            generateWithBooks(booksNumber);
        }
    }

    default void generateWithBooks(BooksNumber booksNumber){
        Human human = (Human) generate();
        addNew(human);
        generateBooksForHuman(human, booksNumber);
    }

    default HashSet<Book> generateBooksForHuman(Human human, BooksNumber booksNumber){
        FictionGenerator fictionGenerator = new FictionGenerator();
        RussianLiteratureGenerator russianLiteratureGenerator = new RussianLiteratureGenerator();
        EnglishLiteratureGenerator englishLiteratureGenerator = new EnglishLiteratureGenerator();
        //
        fictionGenerator.generate(booksNumber.getFictions());
        russianLiteratureGenerator.generate(booksNumber.getRussianLiteratures());
        englishLiteratureGenerator.generate(booksNumber.getEnglishLiteratures());
        //
        human.addBooks(fictionGenerator.convert());
        human.addBooks(russianLiteratureGenerator.convert());
        human.addBooks(englishLiteratureGenerator.convert());
        //
        HashSet<Book> books = new HashSet<>();
        books.addAll(fictionGenerator.convert());
        books.addAll(russianLiteratureGenerator.convert());
        books.addAll(englishLiteratureGenerator.convert());
        return books;
    }

    LinkedHashSet<Record> generateRecords(Human human);

    @Override
    default void addNew(Object human){
        get().add(human);
    }

    default Human convert(Object human){
        return (Human) human;
    }

    default HashSet<Human> convert(){
        HashSet<Object> humans = get();
        HashSet<Human> humansConverted = new HashSet<>();
        for(Object human : humans){
            humansConverted.add(convert(human));
        }
        return humansConverted;
    }

    // GET

    ArrayList<String> getFirstNames();

    ArrayList<String> getLastNames();

    default String getCorrectLastName(String firstName, String lastName){
        if(!isMale(firstName)) return lastName+"??";
        return lastName;
    }

    default String getSecondName(String firstName){
        String secondName = getRandomMaleName();
        if(secondName.endsWith("??")) secondName = secondName.substring(0, secondName.length()-1)+"??";
        else secondName += "??";
        if(isMale(firstName)) secondName += "??????";
        else secondName += "??????";
        return secondName;
    }

    default String getRandomMaleName(){
        ArrayList<String> firstNames = getFirstNames();
        while(true){
            String firstName = firstNames.get((int)(Math.random()*firstNames.size()));
            if(isMale(firstName)) return firstName;
        }
    }

    default boolean isMale(String firstName){
        return Human.isMale(firstName);
    }

}
