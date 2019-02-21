package com.example.week6weekend.view.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.week6weekend.R;
import com.example.week6weekend.databinding.ActivityMain2Binding;
import com.example.week6weekend.model.pojos.Book;
import com.example.week6weekend.viewmodel.MainViewModel;

public class Main2Activity extends AppCompatActivity {
    public static final String TAG = "FRANK: ";
    ActivityMain2Binding activityMain2Binding;
    Intent intent;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        activityMain2Binding.setMainViewModel(new MainViewModel(getApplication(), new Book()));

        //Get the intent sent from MainActivity
        intent = getIntent();

        //Pull the book sent with the intent
        book = intent.getParcelableExtra("book");
        Log.d(TAG, "onCreate: " + book.getTitle());

        //Set the book to be displayed in Activity 2
        activityMain2Binding.setBook(book);
        activityMain2Binding.executePendingBindings();


    }
}
