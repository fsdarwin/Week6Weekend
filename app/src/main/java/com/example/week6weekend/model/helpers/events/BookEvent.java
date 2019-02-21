package com.example.week6weekend.model.helpers.events;

import com.example.week6weekend.model.pojos.Book;

import java.util.ArrayList;

public class BookEvent {

    private final ArrayList<Book> books;

    public BookEvent(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
