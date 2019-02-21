package com.example.week6weekend.model.helpers;

import android.content.Context;
import android.util.Log;

import com.example.week6weekend.model.helpers.events.BookEvent;
import com.example.week6weekend.model.pojos.Book;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    public static final String TAG = "FRANK: ";
    public static ArrayList<Book> books;

    public static void asyncOkHttpApiCall(String url, Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResponse;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    jsonResponse = response.body().string();
                    Gson gson = new Gson();

                    //Get an array of books from the jsonResponse
                    Book[] BookArray = gson.fromJson(jsonResponse, Book[].class);

                    //Make a List of type book from the array of books
                    List<Book> bookList = Arrays.asList(BookArray);

                    //Make an arrayList of the List of books for the recycler view
                    books = new ArrayList<>(bookList);
                    Log.d(TAG, "onResponse: " + BookArray[0].getAuthor() + BookArray[0].getTitle());

                    //Send the ArrayList to MainActivity
                    EventBus.getDefault().post(new BookEvent(books));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}