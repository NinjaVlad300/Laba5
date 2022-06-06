package containpackage.model.entities.books;

public class Fiction extends Book{

    public Fiction(String author, String title){
        super(author, title);
    }

    @Override
    public String toString() {
        return "Художественная" +
                " автор '" + getAuthor() + '\'' +
                ", название '" + getTitle() + '\'';
    }
}
