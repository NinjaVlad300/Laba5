package containpackage.model.entities.humans;

public class Professor extends Human{

    private final String secondName;

    public Professor(String firstName, String secondName, String lastName){
        super(firstName, lastName);
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }


    @Override
    public String getName(){
        return getFirstName()+" "+getSecondName()+" "+getLastName();
    }


    @Override
    public String toString(){
        return "\n Преподаватель " + getFirstName() + " " + getSecondName() + " " + getLastName() + '\'' +
                ", \n\tкниги " + getBooks() +
                  "\n\n";
    }

}
