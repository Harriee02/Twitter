package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import org.parceler.Parcels;

public class ImageDetail extends AppCompatActivity {
    ImageView tweetPic;
    Context context;
    TweetAdapter adapter;
    Tweet tweet;
    String imageUrl;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail);
        //tweetPic = findViewById(R.id.tweetImageDetail);
        name = findViewById(R.id.textView2);
        tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
//        imageUrl = tweet.image;
        //Log.i("HelloWorld",tweet.image);
        name.setText(tweet.user.screenName);

//        Glide.with(context)
//                .load(imageUrl)
//                .centerCrop()
//                .transform(new RoundedCorners(75))
//                .into(tweetPic);

    }


//    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
//        Tweet tweet = new Tweet();
//        tweet.body = jsonObject.getString("text");
//        tweet.createdAt = jsonObject.getString("created_at");
//        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
//
//
//
//        if(!jsonObject.isNull("extended_entities")){
//            JSONObject extendedEntities = jsonObject.getJSONObject("extended_entities");
//            JSONArray jsonArray = extendedEntities.getJSONArray("media");
//            JSONObject media = jsonArray.getJSONObject(0);
//            tweet.image = String.format("%s:large", media.getString("media_url_https"));
//        }
//        else{
//            tweet.image = "";
//        }
//
//        return tweet;
//    }

}
