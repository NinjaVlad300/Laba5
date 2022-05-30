package com.example.lab5.books.bgen;

import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusEd;
import com.example.lab5.books.classes.rus.RusFic;

import java.util.concurrent.ThreadLocalRandom;

public class BookFactory {

    ImpB imp;
    GenBook genBook = new GenBook();

    public BookFactory(ImpB imp) {
        this.imp = imp;
    }

    public Book createBook() {
        Book book;
        int rand = ThreadLocalRandom.current().nextInt(0, 100);
        if (rand < 25) {
            book = createEngEd();
        } else if (rand < 50) {
            book = createEngFic();
        } else if (rand < 75) {
            book = createRusEd();
        } else {
            book = createRusFic();
        }
        return book;
    }

    public EngEd createEngEd() {
        return new EngEd(genBook.genS(imp.getArrEnEdNames()), genBook.genS(imp.getArrEnEdAuthors()), genBook.genS(imp.getArrEnEdUniversities()));
    }

    public EngFic createEngFic() {
        return new EngFic(genBook.genS(imp.getArrEnFicNames()), genBook.genS(imp.getArrEnFicAuthors()));
    }

    public RusEd createRusEd() {
        return new RusEd(genBook.genNameRusEd(imp.getArrRuEdNames()));
    }

    public RusFic createRusFic() {
        return new RusFic(genBook.genS(imp.getArrRuFicNames()),genBook.genS(imp.getArrRuFicAuthors()));
    }

}
