package model.entities.books;

public abstract class Literature extends Book{

    private final String discipline;

    public Literature(String author, String title, String discipline){
        super(author, title);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

}
