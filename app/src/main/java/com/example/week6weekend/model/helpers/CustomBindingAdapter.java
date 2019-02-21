package com.example.week6weekend.model.helpers;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/* This is a specialized binding adapter to Glide images
        into the recycler view
 */

public class CustomBindingAdapter
{
    @BindingAdapter({"bind:image_url"})
    public static void loadImage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext()).load(url)
                .apply(new RequestOptions().override(150, 150)).into(imageView);
    }
}