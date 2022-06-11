package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TweetDetails extends AppCompatActivity {
    ImageView profileImage;
    TextInputLayout tweetLayout;
    EditText tweetDetail;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet_detail);
        profileImage = findViewById(R.id.profileImage);
        tweetDetail = findViewById(R.id.tweetDetail);
        tweetLayout = findViewById(R.id.tweetLayout);


//        Glide.with(context).load(tweet.user.profileImageUrl).into(profileImage);
//        tweetDetail.setText();

    }
}
