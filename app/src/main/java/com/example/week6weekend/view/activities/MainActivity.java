package com.example.week6weekend.view.activities;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.TextView;

import com.example.week6weekend.R;
import com.example.week6weekend.model.adapters.RvAdapter;
import com.example.week6weekend.model.helpers.OkHttpHelper;
import com.example.week6weekend.model.helpers.events.BookEvent;
import com.example.week6weekend.model.helpers.events.SelectionEvent;
import com.example.week6weekend.model.pojos.Book;
import com.example.week6weekend.viewmodel.MainViewModel;
import com.example.week6weekend.databinding.ActivityMainBinding;
import com.flurry.android.FlurryAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import static com.example.week6weekend.model.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding activityMainBinding;
    public static final String TAG = "FRANK: ";

    ArrayList<Book> bookList;
    Book selectedBook;
    OkHttpHelper okHttpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Build the Flurry agent
        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "83HJKXGNT3YSGY78RVXJ");
        //Execute the bindings with the MainViewModel
        activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setMainViewModel(new MainViewModel(getApplication(), new Book()));
        activityMainBinding.executePendingBindings();
        //API call to get the book list
        okHttpHelper = new OkHttpHelper();
        okHttpHelper.asyncOkHttpApiCall(BASE_URL, this);

    }

    @BindingAdapter("android:text")
    public static void setTextViewsText(TextView tv, String message) {

        tv.setText(message);
    }
    //EventBus register and unregister
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    /*This event returns the book list from the Okhttp3 API call
        and finishes the binding with the recycler view */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BookEvent event) {
        if (event != null) {
            Log.d(TAG, "onMessageEvent: ");
            bookList = event.getBooks();
            activityMainBinding.rvActMain.setLayoutManager(new LinearLayoutManager(this));
            RvAdapter recyclerViewAdapter = new RvAdapter(bookList);
            activityMainBinding.rvActMain.setAdapter(recyclerViewAdapter);
        }
    }
    /*This event takes the selected book and passes it to Main2Activity
        for display
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(SelectionEvent event) {
        if (event != null) {
            selectedBook = event.getBook();
            Log.d(TAG, "onSelectionEvent: " + selectedBook.getTitle());
            //Create intent
            Intent goMain2 = new Intent(this, Main2Activity.class);
            //Put selected book into intent
            goMain2.putExtra("book", selectedBook);
            startActivity(goMain2);
        }
    }
}