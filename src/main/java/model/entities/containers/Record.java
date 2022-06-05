package model.entities.containers;

import model.entities.books.Book;
import model.entities.humans.Human;

public class Record{

    private Human human;
    private Book book;
    private int month;

    public Record(Human human, Book book, int month) {
        this.human = human;
        this.book = book;
        this.month = month;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "\n Запись" + " "+
                human.getClass().getSimpleName() + " '" + human.getFirstName() + " " + human.getLastName() + "'" +
                "\n Книга " + book +
                " месяц " + month +"\n"
                ;
    }

}