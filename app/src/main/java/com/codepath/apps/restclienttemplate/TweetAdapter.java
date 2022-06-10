package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    public static final String TAG ="WORKS!";

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }

    public TweetAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProfileImage;
        TextView tvScreenName;
        TextView tvBody;
        ImageView tweetImage;
        TextView tweetTime;
        TextView screenName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            screenName = itemView.findViewById(R.id.screenName);
            tweetImage = itemView.findViewById(R.id.tweetPic);
            tweetTime = itemView.findViewById(R.id.tweetTime);
            tweetImage.setClickable(true);

        }
        public void bind(Tweet tweet){
            tvBody.setText(tweet.body);
            screenName.setText(tweet.user.name);
            tvScreenName.setText(tweet.user.screenName);// Experimenting with   changing the screenName to the created time but the text is not changing.
            //Where does
            Glide.with(context)
                    .load(tweet.user.profileImageUrl)
                    .transform(new RoundedCorners(75))
                    .into(ivProfileImage);
            if (!tweet.image.equals("")){
                tweetImage.setVisibility(View.VISIBLE);
                Glide.with(context)
                        .load(tweet.image)
                        .centerCrop()
                        .transform(new RoundedCorners(75))
                        .into(tweetImage);
            }
            else{
                tweetImage.setVisibility(View.GONE);
            }
            tweetTime.setText(tweet.getRelativeTimeAgo(tweet.createdAt));
            tweetImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "yay!");
                    Intent imageDetail = new Intent(context, ImageDetail.class);
                    imageDetail.putExtra(Tweet.class.getName(), Parcels.wrap(tweet));
                    context.startActivity(imageDetail);
                }
            });




        }


    }




}
