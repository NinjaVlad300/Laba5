package model.generators.books;

import model.entities.books.Book;
import model.generators.Generator;
import model.generators.sub.RandomIntegerGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public interface BookGenerator extends RandomIntegerGenerator, Generator{

    default void generate(int booksNumber){
        for(int i=1; i<=booksNumber; i++){
            Book book = (Book) generate();
            addNew(book);
        }
    }

    default Book convert(Object book){
        return (Book) book;
    }

    default HashSet<Book> convert(){
        HashSet<Object> books = get();
        HashSet<Book> booksConverted = new HashSet<>();
        for(Object book : books){
            booksConverted.add(convert(book));
        }
        return booksConverted;
    }

    // GET

    ArrayList<String> getAuthors();

    ArrayList<String> getTitles();

}
