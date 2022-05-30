package com.example.lab5.users.ugen;

import com.example.lab5.books.classes.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class GenUser {

    public String genS(String[] arr) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        return s;
    }

    public String genWMiddlename(String[] arr) {
        String middlename = genS(arr);
        String wMiddlename = middlename.substring(0, middlename.length() - 3) + "вна";
        return wMiddlename;
    }

    public String genWSurname(String[] arr) {
        String surname = genS(arr);
        String wSurname = "";
        if (surname.endsWith("в") || surname.endsWith("н")) {
            wSurname = surname + "а";
        } else if (surname.endsWith("ий")) {
            wSurname = surname.substring(0, surname.length() - 2) + "ая";
        } else {
            wSurname = surname;
        }
        return wSurname;
    }

    public HashSet genBooks(ArrayList<Book> booksList) {
        int num = ThreadLocalRandom.current().nextInt(3, 11);
        HashSet<Book> books = new HashSet<>();
        for (int i = 0; i < num; i++) {
            books.add(booksList.get(ThreadLocalRandom.current().nextInt(0, booksList.size())));
        }
        return books;
    }

}
