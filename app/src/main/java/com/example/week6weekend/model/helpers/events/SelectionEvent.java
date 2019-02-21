package com.example.week6weekend.model.helpers.events;

import com.example.week6weekend.model.pojos.Book;

public class SelectionEvent {
    private final Book book;

    public SelectionEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
