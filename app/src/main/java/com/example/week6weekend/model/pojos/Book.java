
package com.example.week6weekend.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.example.week6weekend.model.helpers.events.SelectionEvent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.greenrobot.eventbus.EventBus;

public class Book implements Parcelable {
    public static final String TAG = "FRANK: ";

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("author")
    @Expose
    private String author;
    public final static Creator<Book> CREATOR = new Creator<Book>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return (new Book[size]);
        }

    };

    public Book(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.imageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(imageURL);
        dest.writeValue(author);
    }
    //OnClick from the item.xml
    public void onClick(Book book) {
        Log.d(TAG, "onClick: " + book.getTitle());
        EventBus.getDefault().post(new SelectionEvent(book));
    }

    public int describeContents() {
        return 0;
    }

}
