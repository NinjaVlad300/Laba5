package model.entities.books;

public class BooksNumber{

    private int fictions;
    private int russianLiteratures;
    private int englishLiteratures;

    public BooksNumber(int fictions, int russianLiteratures, int englishLiteratures) {
        this.fictions = fictions;
        this.russianLiteratures = russianLiteratures;
        this.englishLiteratures = englishLiteratures;
    }

    public int getFictions() {
        return fictions;
    }

    public void setFictions(int fictions) {
        this.fictions = fictions;
    }

    public int getRussianLiteratures() {
        return russianLiteratures;
    }

    public void setRussianLiteratures(int russianLiteratures) {
        this.russianLiteratures = russianLiteratures;
    }

    public int getEnglishLiteratures() {
        return englishLiteratures;
    }

    public void setEnglishLiteratures(int englishLiteratures) {
        this.englishLiteratures = englishLiteratures;
    }

}
