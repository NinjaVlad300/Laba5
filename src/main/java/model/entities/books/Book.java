package model.entities.books;

public abstract class Book{

    private final String author;
    private final String title;

    public Book(String author, String title) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}
