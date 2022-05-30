package com.example.lab5.users.ugen;

import com.example.lab5.books.classes.Book;
import com.example.lab5.users.classes.Professor;
import com.example.lab5.users.classes.Student;
import com.example.lab5.users.classes.User;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserFactory {

    ImpU imp;
    GenUser genUser = new GenUser();

    public UserFactory(ImpU imp) {
        this.imp = imp;
    }

    public User createUser(ArrayList<Book> booksList) {
        User user;
        if (ThreadLocalRandom.current().nextInt(0, 100) > 60) {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 10) {
                user = createWProfessor();
            } else {
                user = createProfessor();
            }
        } else {
            if (ThreadLocalRandom.current().nextInt(0, 100) > 70) {
                user = createWStudent();
            } else {
                user = createStudent();
            }
        }
        user.setBooks(genUser.genBooks(booksList));
        return user;
    }

    public Student createStudent() {
        return new Student(genUser.genS(imp.getArrNames()), genUser.genS(imp.getArrSurnames()));
    }

    public Student createWStudent() {
        return new Student(genUser.genS(imp.getArrWNames()), genUser.genWSurname(imp.getArrSurnames()));
    }

    public Professor createProfessor() {
        return new Professor(genUser.genS(imp.getArrNames()), genUser.genS(imp.getArrMiddlenames()), genUser.genS(imp.getArrProfSurnames()));
    }

    public Professor createWProfessor() {
        return new Professor(genUser.genS(imp.getArrWNames()), genUser.genWMiddlename(imp.getArrMiddlenames()), genUser.genWSurname(imp.getArrProfSurnames()));
    }

}
