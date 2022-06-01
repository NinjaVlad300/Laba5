package model.entities;

import model.entities.humans.Human;

import java.util.HashSet;

public class Library{

    private HashSet<Human> students;
    private HashSet<Human> professors;

    public Library(){
        this.students = new HashSet<>();
        this.professors = new HashSet<>();
    }

    public HashSet<Human> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Human> students) {
        this.students = students;
    }

    public HashSet<Human> getProfessors() {
        return professors;
    }

    public void setProfessors(HashSet<Human> professors) {
        this.professors = professors;
    }

    //

    public void addStudent(Human student){
        getStudents().add(student);
    }

    public void addProfessor(Human professor){
        getProfessors().add(professor);
    }

    //

    public void removeStudent(Human student){
        getStudents().remove(student);
    }

    public void removeProfessor(Human professor){
        getProfessors().remove(professor);
    }

    //


    @Override
    public String toString() {
        return "Library{" +
                "\nstudents=" + students +
                "\n, professors=" + professors +
                '}';
    }
}
