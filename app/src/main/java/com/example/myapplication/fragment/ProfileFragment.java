package com.example.myapplication.fragment;

import android.util.Log;

import com.example.myapplication.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostFragment{
    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        // time
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        // what does it do ? does it only get post.getDescription but why didn't we need to include it !!!
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with getting post", e);
                }
                for (Post post : posts){
                    Log.i(TAG, "Post: " + post.getDescription() + ", users: " + post.getUser());
                }
                allPost.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
