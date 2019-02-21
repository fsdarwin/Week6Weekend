package com.example.week6weekend.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.week6weekend.model.pojos.Book;
import com.example.week6weekend.view.activities.Main2Activity;

import static android.support.v4.content.ContextCompat.startActivity;

public class MainViewModel extends AndroidViewModel implements Observable {

    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    @Bindable
    private String bookAuthor;
    @Bindable
    private String booTitle;

    Book book;


    public MainViewModel(@NonNull Application application, Book book) {
        super(application);
        this.book = book;
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }
}
