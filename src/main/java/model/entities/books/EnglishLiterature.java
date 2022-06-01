package model.entities.books;

public class EnglishLiterature extends Literature{

    private final String level; // for magister or bachelor
    private final String university;

    public EnglishLiterature(String author, String title, String discipline, String level, String university){
        super(author, title, discipline);
        this.level = level;
        this.university = university;
    }

    public String getLevel() {
        return level;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String toString() {
        return "\n\tEnglishLiterature" +
                " author '" + getAuthor() + '\'' +
                ", title '" + getTitle() + '\'' +
                ", discipline '" + getDiscipline() + '\'' +
                ", level '" + getLevel() + '\'' +
                ", university '" + getUniversity() + '\'';
    }

}
