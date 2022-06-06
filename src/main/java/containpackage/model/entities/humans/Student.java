package containpackage.model.entities.humans;

public class Student extends Human{

    public Student(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public String getName(){
        return getFirstName()+" "+getLastName();
    }

    @Override
    public String toString(){
        return "\n Студент " + getFirstName() + " " + getLastName() + " " +
                ", \n\tкниги " + getBooks() +
                 "\n\n";
    }

}
