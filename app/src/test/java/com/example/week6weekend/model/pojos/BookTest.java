package com.example.week6weekend.model.pojos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.example.week6weekend.BR.book;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testSetTitle() {
        Book book = new Book();
        book.setTitle("test");
        assertEquals("test", book.getTitle());
    }

    @Test
    public void testSetImageURL() {
        Book book = new Book();
        book.setImageURL("test");
        assertEquals("test", book.getImageURL());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book();
        book.setAuthor("test");
        assertEquals("test", book.getAuthor());
    }
}